package com.example.Online_store.Orders;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int order_id;
    Date date = new Date();


    public Orders() {
    }


    public Orders(int order_id, Date date) {
        this.order_id = order_id;
        this.date = date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", date=" + date +
                '}';
    }
}
