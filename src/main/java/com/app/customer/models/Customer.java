package com.app.customer.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data @NoArgsConstructor @ToString
@Document(collection = "customers")
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    @NotNull(message = "Email should not be null")
    @Email
    private String email;
    private String password;
    @NotNull(message = "Phone should not be null")
    private String phone;
    private String user_id;
    private String account_id;
    @Transient
    private Account account;

    public Customer(String firstName, String lastName, String address, String email, String password, String phone, String user_id, String account_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.user_id = user_id;
        this.account_id = account_id;
    }
}
