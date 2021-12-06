package com.example.Online_store.Cart;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cart_id;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "Product_id")
    private Products products;

    public Cart() {
    }

    public Cart(int cart_id, User user, Products products) {
        Cart_id = cart_id;
        this.user = user;
        this.products = products;
    }

    public int getCart_id() {
        return Cart_id;
    }

    public void setCart_id(int cart_id) {
        Cart_id = cart_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}


