package com.example.schedulerdemo.scheduler;

import com.example.schedulerdemo.model.Product;
import com.example.schedulerdemo.service.ProductService;
import com.example.schedulerdemo.service.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionScheduler {
    final
    ProductService productService;

    final
    PromotionService promotionService;

    public PromotionScheduler(ProductService productService, PromotionService promotionService) {
        this.productService = productService;
        this.promotionService = promotionService;
    }

    @Scheduled(cron = "* * * * * *")
    public void cronJob(){
        List<Product> productPromoList = productService.getAll();
        promotionService.sendFCM(productPromoList);
    }
}
