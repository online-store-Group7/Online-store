package com.example.Online_store.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // get All products
    public List<Products> getAllProducts(){
        return productsRepository.findAll();
    }

    // get single product by id
    public Products getProduct(String id){
        Integer product_id = Integer.parseInt(id);
        return productsRepository.findById(product_id).orElse(null);
    }
}
