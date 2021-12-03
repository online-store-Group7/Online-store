package com.example.Online_store.Cart;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import com.example.Online_store.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="cart")
@CrossOrigin("*")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
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
    public Cart addCart(@RequestBody Form form){

       return cartService.saveCart(form.getProduct(), form.getUser());
    }

    @DeleteMapping("/{id}")
    public void deleteCart(@PathVariable String id){
        cartService.deleteCart(id);
    }
}

class Form{
    Products product;
    User user;

    public Products getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }
}
