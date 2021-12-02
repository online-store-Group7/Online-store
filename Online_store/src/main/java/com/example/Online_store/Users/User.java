package com.example.Online_store.Users;

import com.example.Online_store.Cart.Cart;
import com.example.Online_store.Favorite.Favorite;

import javax.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String UserName;
    private String Email;
    private int Phone;
    private String Password;

    @OneToOne
    private Cart cart;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Favorite favorite;

    public User() {
    }

    public User(int id, String userName, String email, int phone, String password) {
        this.id = id;
        this.UserName = userName;
        this.Email = email;
        this.Phone = phone;
        this.Password = password;
    }

    public int getUser_id() {
        return this.id;
    }

    public void setUser_id(int id) {
        this.id = id;
    }

    public String getUserName() {
        return this.UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public int getPhone() {
        return this.Phone;
    }

    public void setPhone(int phone) {
        this.Phone = phone;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public Cart getCart() {
        return this.cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
