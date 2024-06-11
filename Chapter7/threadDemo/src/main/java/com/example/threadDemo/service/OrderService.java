package com.example.threadDemo.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public long getSubtotal(int price, int quantity) throws InterruptedException {
        Thread.sleep(5000); //delay 5 detik
        return price*quantity;
    }

    public long getTotal(){

        OrderRunnable orderRunnableNG = new OrderRunnable(20000,5);
        Thread threadNG = new Thread(orderRunnableNG);
        threadNG.start();

        OrderRunnable orderRunnableTM = new OrderRunnable(4000,10);
        Thread threadTM = new Thread(orderRunnableTM);
        threadTM.start();

        OrderRunnable orderRunnableMA = new OrderRunnable(15000,5);
        Thread threadMA = new Thread(orderRunnableMA);
        threadMA.start();

        try {
            threadNG.join();
            threadTM.join();
            threadMA.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return orderRunnableNG.getSubtotal()+orderRunnableTM.getSubtotal()+orderRunnableMA.getSubtotal();
    }
}
