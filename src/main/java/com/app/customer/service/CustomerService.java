package com.app.customer.service;

import com.app.customer.dao.CustomerRepository;
import com.app.customer.models.Account;
import com.app.customer.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repo;

    @Autowired
    private AccountService accountService;

    public List<Customer> getAll(){
        List<Customer> customers=repo.findAll();
        for(Customer customer:customers){
            System.out.println(customer.getAccount_id());
            Account account=accountService.getAccountById(customer.getAccount_id());
            customer.setAccount(account);
        }
        return customers;
    }

    public Customer findById(String id){
        return repo.findById(id).orElse(new Customer());
    }

    public Customer saveOrUpdate(Customer customer){
        return repo.save(customer);
    }

    public void delete(String id){
        Customer customer=this.findById(id);
        accountService.deleteAccount(customer.getAccount_id());
        repo.deleteById(id);
    }
}
