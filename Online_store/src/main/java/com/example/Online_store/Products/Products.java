package com.example.Online_store.Products;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String title; //@Column(unique = true)
    private double price;
    private String description;
    private int category_id;
    private String image;
    private double rating;

    public Products() {
    }

    public Products(int product_id, String title, double price, String description, int category_id, String image, double rating) {

        this.product_id = product_id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category_id = category_id;
        this.image = image;
        this.rating = rating;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category_id=" + category_id +
                ", image='" + image + '\'' +
                ", rating=" + rating +
                '}';
    }
}
