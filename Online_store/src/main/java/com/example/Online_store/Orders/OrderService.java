package com.example.Online_store.Orders;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductsRepository productsRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductsRepository productsRepository) {
        this.orderRepository = orderRepository;
        this.productsRepository = productsRepository;
    }


    public List getOrders(){
        return orderRepository.findAll();
    }


    public Orders saveOrder(Orders order, Integer product_id){
        Products products = productsRepository.findById(product_id).orElse(null);
        order.setProducts(products);
        return orderRepository.save(order);
    }
}
