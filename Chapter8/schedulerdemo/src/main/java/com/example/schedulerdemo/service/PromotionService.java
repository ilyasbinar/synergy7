package com.example.schedulerdemo.service;

import com.example.schedulerdemo.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {
    public void sendFCM(List<Product> productList){
        //todo: build message
        //todo: kirim notifikasi

        System.out.println("Promotion sent to FCM");
    }
    public void sendToMail(){

    }

}
