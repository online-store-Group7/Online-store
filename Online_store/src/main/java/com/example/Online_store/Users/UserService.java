package com.example.Online_store.Users;
import com.example.Online_store.Cart.Cart;
import com.example.Online_store.Cart.CartRepository;
import com.example.Online_store.Favorite.Favorite;
import com.example.Online_store.Favorite.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CartRepository cartRepository;
    private final FavoriteRepository favoriteRepository;

    @Autowired
    public UserService(UserRepository userRepository,  CartRepository cartRepository, FavoriteRepository favoriteRepository) {
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
        this.favoriteRepository = favoriteRepository;
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User getUser(String id){
        int User_id = Integer.valueOf(id);
        return userRepository.findById(User_id).orElse(null);
    }

    public User addUser(User user){
        Cart cart = new Cart();
        cartRepository.save(cart);
        user.setCart(cart);
        return userRepository.save(user);
    }

    public void deleteUser(String id){
        int User_id = Integer.valueOf(id);
        userRepository.deleteById(User_id);

    }

    public void updateUser(String id, User data){
        int User_id = Integer.valueOf(id);
        User user = userRepository.findById(User_id).orElse(null);

        if (user != null){
            user.setUserName(data.getUserName());
            user.setEmail(data.getPassword());
            user.setPhone(data.getPhone());
            user.setPassword(data.getPassword());
            userRepository.save(user);
            }
        }

        public User getUserby(User user){
        User user1 = userRepository.findById(user.getUser_id()).orElse(null);
            System.out.println(user.getUser_id());
        return user1;
        }
    }


