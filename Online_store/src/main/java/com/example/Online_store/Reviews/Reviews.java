package com.example.Online_store.Reviews;

import javax.persistence.*;


@Entity
@Table(name = "reviews")
public class Reviews {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int comment_id;
    private int User_id;
    private int Product_id;
    private String comment;
    private double rating;
    private String date;


    public Reviews() {
    }

    public Reviews(int comment_id, int user_id, int product_id, String comment, double rating, String Date) {
        this.comment_id = comment_id;
        User_id = user_id;
        Product_id = product_id;
        this.comment = comment;
        this.rating = rating;
        date = Date;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
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
