package com.example.Online_store.Products;

import com.example.Online_store.Cart.Cart;
import com.example.Online_store.Cart.CartRepository;
import com.example.Online_store.Favorite.Favorite;
import com.example.Online_store.Favorite.FavoriteRepository;
import com.example.Online_store.Users.User;
import com.example.Online_store.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final CartRepository cartRepository;
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;


    @Autowired
    public ProductsService(ProductsRepository productsRepository, CartRepository cartRepository, FavoriteRepository favoriteRepository, UserRepository userRepository) {
        this.productsRepository = productsRepository;
        this.cartRepository = cartRepository;
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
    }

    // get All products
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    // get single product by id
    public Products getProduct(String id){
        Integer product_id = Integer.parseInt(id);
        return productsRepository.findById(product_id).orElse(null);
    }

    public void addProduct(Products products){
        productsRepository.save(products);
    }

    // update product
    public void updateProduct(String id, Products data){
        Integer product_id = Integer.parseInt(id);
        Products product = productsRepository.findById(product_id).orElse(null);
        if (product != null){
            product.setTitle(data.getTitle());
            product.setPrice(data.getPrice());
            product.setDescription(data.getDescription());
            product.setImage(data.getImage());
            product.setRating(data.getRating());
            productsRepository.save(product);
        }
    }
}
