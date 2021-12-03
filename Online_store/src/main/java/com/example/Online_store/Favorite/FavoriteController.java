package com.example.Online_store.Favorite;

import com.example.Online_store.Users.User;
import com.example.Online_store.Products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path= "favorite")
@CrossOrigin("*")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Autowired
    public FavoriteController(FavoriteService favoriteService){ this.favoriteService = favoriteService; }

    @GetMapping
    public List<Favorite> getFavorites(){
        return favoriteService.getFavorites();
    }

    @GetMapping("/{id}")
    public Favorite getFavorite(@PathVariable String id){
        return favoriteService.getFavorite(id);
    }

    @PostMapping
    public Favorite addFavorite(@RequestBody Form form){
        System.out.println(form.getProduct());
        System.out.println(form.getUser());

        return favoriteService.saveFavorite(form.getProduct(), form.getUser());
    }

    @DeleteMapping
    public void deleteFavorite(@PathVariable String id){
        favoriteService.deleteFavorite(id);
    }
}

class Form{

    Products product;
    User user;

    public Products getProduct(){ return product; }

    public User getUser(){
        return user;
    }
}

