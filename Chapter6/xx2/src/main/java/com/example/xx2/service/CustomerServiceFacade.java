package com.example.xx2.service;

import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Order;
import com.example.xx2.model.accounts.User;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceFacade {
    final
    CinemaMovieService cinemaMovieService;

    final
    OrderService orderService;

    final
    UserService userService;

    public CustomerServiceFacade(CinemaMovieService cinemaMovieService, OrderService orderService, UserService userService) {
        this.cinemaMovieService = cinemaMovieService;
        this.orderService = orderService;
        this.userService = userService;
    }

    public Order placeOrder(User user, CinemaMovie cinemaMovie, int amount){
        boolean stockAvailable = cinemaMovieService.isAvailable(cinemaMovie, amount);
        if(stockAvailable){
            Order order = orderService.createOrder(user, cinemaMovie, amount);
            boolean success = userService.takePayment(user, cinemaMovie.getPrice()*amount);
            if(success){
                order = orderService.confirmOrder(order);
                cinemaMovieService.adjustStock(cinemaMovie, amount);
                return order;
            }else {
                throw new RuntimeException("Pembayaran Gagal");
            }

        }else {
            throw new RuntimeException("Tiket tidak tersedia sejumlah: "+amount);
        }
    }
}
