package com.akBank.akbank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/cards")
    public String getCardsDetails(){
        return  "Welcome To Cards Controller";
    }
}
