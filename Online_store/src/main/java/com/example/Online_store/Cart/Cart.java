package com.example.Online_store.Cart;

import javax.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Cart_id;
    private int User_id;
    private int Product_id;

    public Cart() {
    }

    public Cart(int Cart_id, int User_id, int Product_id) {
        this.Cart_id = Cart_id;
        this.User_id = User_id;
        this.Product_id = Product_id;
    }

    public int getCart_id() {
        return Cart_id;
    }

    public void setCart_id(int id) {
        this.Cart_id = Cart_id;
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
        return "Cart{" +
                "Cart_id=" + Cart_id +
                ", User_id=" + User_id +
                ", Product_id=" + Product_id +
                '}';
    }
}


