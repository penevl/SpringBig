package com.github.penevl.user;

import com.github.penevl.product.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    int id;
    String name;
    String email;
    String password;
    int phone;
    List<Product> cart = new ArrayList<>();

    public User(){}

    public User(int id, String name, String email, String password, int phone, List<Product> cart) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.cart = cart;
    }


}
