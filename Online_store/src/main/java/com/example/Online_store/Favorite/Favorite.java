package com.example.Online_store.Favorite;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "favorite")
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favorite_id;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER,optional = true)
    @JoinColumn(name = "Product_id")
    private Products products;

    public Favorite() {
    }

    public Favorite(int favorite_id, User user, Products products) {
        this.favorite_id = favorite_id;
        this.user = user;
        this.products = products;
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

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }


    @Override
    public String toString() {
        return "Favorite{" +
                "favorite_id=" + favorite_id +
                '}';
    }
}
