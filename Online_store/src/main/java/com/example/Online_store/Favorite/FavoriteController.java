package com.example.Online_store.Favorite;

import com.example.Online_store.Users.User;
import com.example.Online_store.Products.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path= "favorite")
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
    public Favorite addFavorite(@RequestBody Products products, User user){
        System.out.println(user.getUser_id());
        return favoriteService.saveFavorite(products, user);}

    @DeleteMapping
    public void deleteFavorite(@PathVariable String id){
        favoriteService.deleteFavorite(id);
    }
}

