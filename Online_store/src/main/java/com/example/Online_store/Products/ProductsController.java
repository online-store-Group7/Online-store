package com.example.Online_store.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "products")
public class ProductsController {

    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public List<Products> getAllProducts(){
        return productsService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Products getProduct(@PathVariable String id){
        return productsService.getProduct(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable String id, @RequestBody Products product){
        productsService.updateProduct(id,product);
    }

    @PostMapping
    public void addProduct(@RequestBody Products products){
        productsService.addProduct(products);
    }
}


