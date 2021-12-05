package com.example.Online_store.Favorite;

import com.example.Online_store.Cart.Cart;
import com.example.Online_store.Users.User;
import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import com.example.Online_store.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;
    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository, UserRepository userRepository, ProductsRepository productsRepository){
        this.favoriteRepository = favoriteRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
    }

    public List<Favorite> getFavorites(){return favoriteRepository.findAll(); }

    public Favorite getFavorite(String id){
        int favorite_id = Integer.valueOf(id);
        return favoriteRepository.findById(favorite_id).orElse(null);
    }

    public Favorite saveFavorite(Favorite favorite, int products_id, int user_id){
        User favorite_user = userRepository.findById(user_id).orElse(null);
        favorite.setUser(favorite_user);
        Products added_product = productsRepository.findById(products_id).orElse(null);
        favorite.setProducts(added_product);
        return favoriteRepository.save(favorite);
    }

    public void deleteFavorite(String id){
        int favorite_id = Integer.valueOf(id);
        favoriteRepository.deleteById(favorite_id);
    }
}
