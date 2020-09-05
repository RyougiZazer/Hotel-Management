package com.hotel.demo.service;

import com.hotel.demo.entity.Room;

import java.util.List;

public interface RoomService {
    void addRoom(Room room);

    void updateRoom(Room room);

    Room queryRoomByRoomId(Integer roomId);

    List<Room> queryAllRoom(Room room);

    String deleteRoom(Integer roomid);
}
