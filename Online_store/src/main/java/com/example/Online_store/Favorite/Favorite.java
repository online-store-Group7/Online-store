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

    @ManyToMany
    @JoinColumn(name = "product_favorite", referencedColumnName = "product_id")
    private List<Products> products = new ArrayList<>();

    public Favorite() {
    }

    public Favorite(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favorite_id=" + favorite_id +
                '}';
    }
}
