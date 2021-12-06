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

        return favoriteService.saveFavorite(form.getFavorite(), form.getProduct_id(), form.getUser_id());
    }

    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable String id){
        favoriteService.deleteFavorite(id);
    }
}

class Form{

    private Favorite favorite;
    private int product_id;
    private int user_id;

    public Favorite getFavorite() {
        return favorite;
    }

    public void setFavorite(Favorite favorite) {
        this.favorite = favorite;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

