package com.example.xx2.controller;

import com.example.xx2.model.CinemaMovie;
import com.example.xx2.model.Order;
import com.example.xx2.model.accounts.User;
import com.example.xx2.payload.OrderRequestDto;
import com.example.xx2.payload.OrderResponseDto;
import com.example.xx2.service.CinemaMovieService;
import com.example.xx2.service.CustomerServiceFacade;
import com.example.xx2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("order")
public class OrderController {
    final
    CinemaMovieService cinemaMovieService;

    final
    UserService userService;

    @Autowired
    CustomerServiceFacade customerServiceFacade;

    public OrderController(CinemaMovieService cinemaMovieService, UserService userService) {
        this.cinemaMovieService = cinemaMovieService;
        this.userService = userService;
    }

    @PostMapping("place")
    public ResponseEntity<Map<String, Object>> placeOrder(@RequestBody @Valid OrderRequestDto orderRequestDto,
                                                          BindingResult bindingResult){
        CinemaMovie cinemaMovie = cinemaMovieService.getById(orderRequestDto.getCinemaMovieId());
        User user = userService.getById(orderRequestDto.getUserId());

        Order order = customerServiceFacade.placeOrder(user, cinemaMovie, orderRequestDto.getAmount());

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");

        Map<String, Object> data = new HashMap<>();
        OrderResponseDto orderResponseDto = new OrderResponseDto();
                orderResponseDto.setOrderId(order.getId());
                orderResponseDto.setName(user.getUsername());
        data.put("order", orderResponseDto);
        response.put("data", data);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
