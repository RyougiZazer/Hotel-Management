package com.hotel.demo.controller;

import com.hotel.demo.entity.Order;
import com.hotel.demo.entity.Room;
import com.hotel.demo.service.OrderService;
import com.hotel.demo.service.RoomService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

public class RoomController {

    @Resource
    private RoomService roomService;

    //跳转到addOrder页面上
    @GetMapping(path = "/preAadd")
    public String toAdd(){return "addOrder";}

    @PostMapping(path = "/add")
    public String addOrder(Room room){
        this.roomService.addRoom(room);
        return "redirect:/room/showList";
    }

    //查询
    @RequestMapping(path = "/showList",method = {RequestMethod.GET,RequestMethod.POST})
    public String showList(Model model, Room room) {
        if (room == null) {
            room = new Room();
        }
        List<Room> rooms = this.roomService.queryAllRoom(room);
        model.addAttribute("orders", rooms);
        return "roomList";
    }

    @GetMapping(path = "/showInfo")
    public String showInfo(Integer roomId, Model model){
        System.out.println("需要查询的部门编号是：" + roomId);
        Room room = this.roomService.queryRoomByRoomId(roomId);
        model.addAttribute("room", room);
        System.out.println(room);
        return "roomInfo";
    }

    //修改前置条件
    // 修改的前置方法是- 目的是为了查询出需要修改的部门信息，显示在页面上。
    @GetMapping(path = "/preUpdate/{rid}")
    public String preUpdate(@PathVariable("rid") Integer roomId, Model model){
        System.out.println("当前需要修改信息的房间是：" + roomId);

        Room room = this.roomService.queryRoomByRoomId(roomId);

        model.addAttribute("room", room);

        return "updateRoom";
    }

    @PostMapping(path = "/update")
    public String updateDept(Room room){
        System.out.println("更改后的信息是：" + room);
        this.roomService.updateRoom(room);
        return "redirect:/room/showList";
    }

    // 撤除房间需要条件 - 当前房间下没有订单
    @GetMapping(path = "/disabled/{roomId}")
    public @ResponseBody String disableDept(@PathVariable("roomId") Integer roomId, Model model){
        System.out.println("需要撤除的部门是:" + roomId);
        return this.roomService.deleteRoom(roomId);
    }

}
