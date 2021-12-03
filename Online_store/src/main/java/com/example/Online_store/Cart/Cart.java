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

    @ManyToMany
    @JoinColumn(name = "product_cart",referencedColumnName = "product_id")
    private List<Products> products = new ArrayList<>();

    public Cart() {
    }

    public Cart(int cart_id) {
        this.Cart_id = cart_id;
    }

    public Cart(int Cart_id, List<Products> products) {
        this.Cart_id = Cart_id;
        this.products = products;
    }

    public int getCart_id() {
        return this.Cart_id;
    }

    public void setCart_id(int id) {
        this.Cart_id = Cart_id;
    }

    public List<Products> getProducts() {
        return this.products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "Cart_id=" + this.Cart_id +
                ", products=" + this.products +
//                ", user=" + this.user +
                '}';
    }
}


