package com.myshopping.MYShopping.controller;

import com.myshopping.MYShopping.dto.OrderDetailsDTO;
import com.myshopping.MYShopping.models.OrderTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.myshopping.MYShopping.service.BuyerService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;
    @PostMapping("/placeorder")
    public OrderTable placeOrder(@RequestParam List<OrderDetailsDTO> orders, @RequestParam UUID userId){
    return buyerService.placeOrder(orders,userId);
    }
}
