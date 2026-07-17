package com.cognizant.accountservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("/accounts/{number}")
    public Account getByNumber(@PathVariable String number) {
        return new Account(number, "savings", 234343);
    }
}
