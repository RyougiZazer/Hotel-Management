package com.hotel.demo.service.impl;

import com.hotel.demo.entity.Order;
import com.hotel.demo.entity.Room;
import com.hotel.demo.mapper.OrderMapper;
import com.hotel.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service("OrderService")
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void addOrder(Order order) {
        System.out.println("roomServiceimpl中的方法");
        this.orderMapper.insertOrder(order);
    }

    @Override
    public void updateOrder(Order order) {
        this.orderMapper.updateOrder(order);
    }

    @Override
    public Order selectOrderByOrderId(Integer oid) {
        return this.orderMapper.selectOrderByOrderId(oid);
    }

    @Override
    public String deleteOrder(Integer oid) {
        return null;
    }

}
