package com.app.customer.web;

import com.app.customer.models.Account;
import com.app.customer.models.Customer;
import com.app.customer.service.AccountService;
import com.app.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @GetMapping("")
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.findById(id);
    }

    @PostMapping("/save")
    public Customer save(@Valid @RequestBody Customer customer){
        Account account=accountService.createAccount(customer.getAccount());
        customer.setAccount_id(account.getId());
        customer.setAccount(account);
        customerService.saveOrUpdate(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id){
        customerService.delete(id);
        return "Customer deleted successfully";
    }
}
