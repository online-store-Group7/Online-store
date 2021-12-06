package com.example.Online_store.Orders;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Users.User;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    private String order_date;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "user_id")
    private User user;

    public Orders() {
    }

    public Orders(int order_id, String date, Products products) {
        this.order_id = order_id;
        this.order_date = date;
        this.products = products;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getDate() {
        return order_date;
    }

    public void setDate(String date) {
        this.order_date = date;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", date='" + order_date + '\'' +
                ", products=" + products +
                ", user=" + user +
                '}';
    }
}
