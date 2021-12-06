package com.example.Online_store.Cart;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import com.example.Online_store.Users.User;
import com.example.Online_store.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductsRepository productsRepository;

    @Autowired
    public CartService(CartRepository cartRepository, UserRepository userRepository, ProductsRepository productsRepository){
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.productsRepository = productsRepository;
    }

    public List<Cart> getCarts(){ return cartRepository.findAll(); }

    public Cart getCart(String id){
        int cart_id = Integer.valueOf(id);
        return cartRepository.findById(cart_id).orElse(null);
    }

    public void deleteCart(String id){
        int cart_id = Integer.valueOf(id);
        cartRepository.deleteById(cart_id);
    }

    public Cart saveCart(Cart cart , int product_id, int user_id){
        User cart_user = userRepository.findById(user_id).orElse(null);
        cart.setUser(cart_user);
        Products added_product = productsRepository.findById(product_id).orElse(null);
        cart.setProducts(added_product);
        return cartRepository.save(cart);
      }
}
