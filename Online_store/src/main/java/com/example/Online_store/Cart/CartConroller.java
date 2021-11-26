package com.example.Online_store.Cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="cart")
public class CartConroller {

    private final CartService cartService;

    @Autowired
    public CartConroller(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getCarts(){
        return cartService.getCarts();
    }

    @GetMapping("/{id}")
    public Cart getCart(@PathVariable String id){
        return cartService.getCart(id);
    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart){ return cartService.addCart(cart);}

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id){
        cartService.deleteCart(id);
    }
}
