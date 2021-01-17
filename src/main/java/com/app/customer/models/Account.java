package com.app.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Account {
    private String id;
    private double amount;
    private String accountType_id;
    private AccountType accountType;
}
