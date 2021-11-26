package com.example.Online_store.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){ this.cartRepository = cartRepository; }

    public List<Cart> getCarts(){ return cartRepository.findAll(); }

    public Cart getCart(String id){
        int cart_id = Integer.valueOf(id);
        return cartRepository.findById(cart_id).orElse(null);
    }

    public Cart addCart(Cart cart){
        return cartRepository.save(cart);
    }

    public void deleteCart(String id){
        int cart_id = Integer.valueOf(id);
        cartRepository.deleteById(cart_id);
    }
}
