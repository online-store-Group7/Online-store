package com.example.Online_store.Orders;

import com.example.Online_store.Products.Products;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;

    @Temporal(TemporalType.DATE)
    Date date = new Date(System.currentTimeMillis());

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "product_id")
    private Products products;

    public Orders() {
    }

    public Orders(int order_id, Date date, Products products) {
        this.order_id = order_id;
        this.date = date;
        this.products = products;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", date=" + date +
                '}';
    }
}
