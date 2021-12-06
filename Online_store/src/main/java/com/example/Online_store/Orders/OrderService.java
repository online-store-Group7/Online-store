package com.example.Online_store.Orders;

import com.example.Online_store.Products.Products;
import com.example.Online_store.Products.ProductsRepository;
import com.example.Online_store.Users.User;
import com.example.Online_store.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductsRepository productsRepository;
    private final UserRepository userRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ProductsRepository productsRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productsRepository = productsRepository;
        this.userRepository = userRepository;
    }


    public List getOrders(){
        return orderRepository.findAll();
    }


    public Orders saveOrder(Orders order, Integer product_id, Integer user_id){
        System.out.println("_______Product id_______" +product_id);
        System.out.println(user_id);
        Products products = productsRepository.findById(product_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        order.setProducts(products);
        order.setUser(user);
        return orderRepository.save(order);
    }
}
