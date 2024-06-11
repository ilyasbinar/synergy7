package com.example.threadDemo.controller;

import com.example.threadDemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("")
    public String order() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        long subtotalNasiGoreng = orderService.getSubtotal(20000, 5);
        long subtotalEsTehManis = orderService.getSubtotal(4000, 10);
        long subtotalMieAyam = orderService.getSubtotal(15000, 5);

        long total = subtotalNasiGoreng+subtotalEsTehManis+subtotalMieAyam;
        sw.stop();
        System.out.println(sw.prettyPrint());
        return "Harga Total: " +total;
    }

    @GetMapping("runnable")
    public String orderRunnable() throws InterruptedException {
        StopWatch sw = new StopWatch();
        sw.start();
        long total = orderService.getTotal();
        sw.stop();
        System.out.println(sw.prettyPrint());
        return "Harga Total: " +total;
    }
}
