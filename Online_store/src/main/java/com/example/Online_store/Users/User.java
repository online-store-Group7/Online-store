package com.example.Online_store.Users;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    private int User_id;
    private String UserName;
    private String Email;
    private int Phone;
    private String Password;

    public User() {
    }

    public User(int user_id, String userName, String email, int phone, String password) {
        User_id = user_id;
        UserName = userName;
        Email = email;
        Phone = phone;
        Password = password;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
