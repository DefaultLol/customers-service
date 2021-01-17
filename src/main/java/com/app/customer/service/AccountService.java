package com.app.customer.service;

import com.app.customer.models.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="account-service",url = "http://localhost:8082/account")
public interface AccountService {
    @GetMapping("")
    public List<Account> getAllAccounts();

    @PostMapping("/save")
    public Account createAccount(@RequestBody Account account);

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable String id);

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable String id);
}
