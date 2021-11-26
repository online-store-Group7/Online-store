package com.example.Online_store.Favorite;

import javax.persistence.*;

@Entity
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int favorite_id;
    private int User_id;
    private int Product_id;

    public Favorite() {
    }

    public Favorite(int favorite_id, int User_id, int Product_id) {
        this.favorite_id = favorite_id;
        this.User_id = User_id;
        this.Product_id = Product_id;
    }

    public int getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(int favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public int getProduct_id() {
        return Product_id;
    }

    public void setProduct_id(int product_id) {
        Product_id = product_id;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "favorite_id=" + favorite_id +
                ", User_id=" + User_id +
                ", Product_id=" + Product_id +
                '}';
    }
}
