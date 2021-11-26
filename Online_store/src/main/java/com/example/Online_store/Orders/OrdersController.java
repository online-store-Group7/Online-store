package com.example.Online_store.Orders;

import com.example.Online_store.Products.Products;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "orders")
public class OrdersController {

    private final OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Orders> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping
    public Orders addOrder(@RequestBody Form form) {
        return orderService.saveOrder(form.getOrder(), form.getProductId());
    }

}
class Form{
    private Orders orders;
    private Integer product_id;

    public Orders getOrder() {
        return orders;
    }

    public Integer getProductId() {
        return product_id;
    }
}
