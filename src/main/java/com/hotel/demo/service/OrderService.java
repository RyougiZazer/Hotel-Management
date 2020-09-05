package com.hotel.demo.service;

import com.hotel.demo.entity.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void updateOrder(Order order);

    Order selectOrderByOrderId(Integer orderId);

    String deleteOrder(Integer orderid);

    List<Order> queryAllOrders(Order order);
}
