package com.example.schedulerdemo.scheduler;

import com.example.schedulerdemo.fcm.dto.NotificationRequest;
import com.example.schedulerdemo.fcm.service.FCMService;
import com.example.schedulerdemo.model.Product;
import com.example.schedulerdemo.service.ProductService;
import com.example.schedulerdemo.service.PromotionService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
public class PromotionScheduler {
    final
    ProductService productService;

    final
    PromotionService promotionService;

    final
    FCMService fcmService;

    public PromotionScheduler(ProductService productService, PromotionService promotionService, FCMService fcmService) {
        this.productService = productService;
        this.promotionService = promotionService;
        this.fcmService = fcmService;
    }

    @Scheduled(cron = "*/5 * * * * *")
    public void cronJob() throws ExecutionException, InterruptedException {
        List<Product> productPromoList = productService.getAll();
        NotificationRequest request = new NotificationRequest();
        request.setTitle("Promo Siang Binarfud");
        request.setBody("Silakan order pada Pukul 12.00 - 13.00 untuk mendapatakan diskon 20%");
        request.setToken("dsuwPnxNpHZewfc8w-_Heo:APA91bHS92pwASe9FSdaUi3SHlJqiFOeAnjPUUKjSRCAOtRXQTUCHDOy7JpJFOU9Cn3hSmtMpPOxhxcUtVcGWp_1AjT73YMe6ktfISQO7gqI89270Gi3hacTKRzg99ozngP7fL7ZtiSj");
        fcmService.sendMessageToToken(request);
        promotionService.sendFCM(productPromoList);
    }
}
