package com.hotel.demo.service.impl;

import com.hotel.demo.entity.Room;
import com.hotel.demo.entity.Order;
import com.hotel.demo.mapper.RoomMapper;
import com.hotel.demo.mapper.OrderMapper;
import com.hotel.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    @Resource
    private RoomMapper roomMapper;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public void addRoom(Room room) {
        System.out.println("roomServiceimpl中的方法");
        this.roomMapper.insertRoom(room);
    }

    @Override
    public void updateRoom(Room room) {
        this.roomMapper.updateRoom(room);
    }

    @Override
    public Room queryRoomByRoomId(Integer rid) {
        return this.roomMapper.selectRoomByRoomId(rid);
    }

    @Override
    public List<Room> queryAllRoom(Room room) {
        return this.roomMapper.selectAllRoom(room);
    }

    @Override
    public String deleteRoom(Integer rid) {
        String msg = "该房间存在订单，无法删除";
        List<Order> orders = this.orderMapper.selectOrderByRoomId(rid);
        if (orders.isEmpty()) {
            this.roomMapper.deleteRoomByRoomId(rid);
            msg = "success";
        }
        return msg;
    }
}
