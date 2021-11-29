package com.example.Online_store.Reviews;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Users.User;

import javax.persistence.*;


@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comment_id;
    private String comment;
    private double rating;
    private String date;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "Product_id")
    private Products products;

    public Reviews() {
    }

    public Reviews(int comment_id, int user_id, int product_id, String comment, double rating, String date, User user) {
        this.comment_id = comment_id;
        this.comment = comment;
        this.rating = rating;
        this.date = date;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        date = Date;
    }
}
