package com.example.demoTransactional;

import com.example.demoTransactional.model.Order;
import com.example.demoTransactional.model.Product;
import com.example.demoTransactional.service.OrderService;
import com.example.demoTransactional.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @GetMapping()
    public String order(){
        Product productMieAyam = productService.getById(1L);

        Order order = new Order();
        order.setQuantity(3);
        order.setProduct(productMieAyam);

        orderService.placeOrder(order, 1);

        return "Success";
    }
}
