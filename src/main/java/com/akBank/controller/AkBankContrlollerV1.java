package com.akBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AkBankContrlollerV1 {

    @GetMapping("/welcome")
    public String welcome(){
        return  "Welcome To Ak Bank";
    }

}
