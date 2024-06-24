package com.example.schedulerdemo.service;


import com.example.schedulerdemo.model.Order;
import com.example.schedulerdemo.model.OrderItem;
import com.example.schedulerdemo.model.OrderStatus;
import com.example.schedulerdemo.model.Product;
import com.example.schedulerdemo.repository.OrderItemRepository;
import com.example.schedulerdemo.repository.OrderRepository;
import com.example.schedulerdemo.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductService productService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void placeOrder(Order order) {
        // Save the order
        orderRepository.save(order);

        for (OrderItem item : order.getItems()) {
            // Find the product
            Product product = productRepository.findById(item.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Update the stock quantity
            int newQuantity = product.getQuantity() - item.getQuantity();
            if (newQuantity < 0) {
                throw new RuntimeException("Insufficient stock");
            }
            product.setQuantity(newQuantity);
            productRepository.save(product);

            // Save the order item
            item.setOrder(order);
            orderItemRepository.save(item);
        }

        order.setStatus(OrderStatus.COMPLETED);
        orderRepository.save(order);
    }

    @Override
    @Transactional
    public void placeOrderNewPropagation(Order order) {
        order.setCustomerName("testUpdateProductQuantityWithRequiresNewPropagationAndInnerException");
        order.setStatus(OrderStatus.PENDING);
        orderRepository.save(order);

        try {
            OrderItem item = new OrderItem();
            item.setProduct(new Product()); // Here we passed empty Product, so exception occured.
            productService.updateProductQuantityWithRequiresNewPropagation(item);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        // Verify that the order was created.
        Order savedOrder = orderRepository.findById(order.getId()).get();
        log.info("Customer Name: "+order.getCustomerName());
    }

}
