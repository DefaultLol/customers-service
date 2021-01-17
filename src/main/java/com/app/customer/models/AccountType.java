package com.app.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AccountType {
    private String id;
    private String name;
}
