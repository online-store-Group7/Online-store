package com.example.Online_store.Products;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

//    @GetMapping
//    public List<Products> getAllProducts(){
//        return ProductsService.getAllProducts();
//    }

//    @GetMapping("/{id}")
//    public Products getProduct(@PathVariable String id){
//        return ProductsService.getProduct(id);
//    }
}
