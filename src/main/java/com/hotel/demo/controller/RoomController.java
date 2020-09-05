package com.hotel.demo.controller;


import com.hotel.demo.entity.Emp;
import com.hotel.demo.entity.Room;
import com.hotel.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Controller
@RequestMapping("/room_manager")
public class RoomController {

    @Autowired
    private RoomService roomService;


    @GetMapping(path = "/")
    public String init(Model model){
        List<Room> rooms = this.roomService.queryAllRoom(new Room());
        model.addAttribute("rooms",rooms);
        return "room_manager";
    }

    @PostMapping(path = "/add")
    public String addOrder(Room room, Model model){
        System.out.println("新启用的房间信息是：" + room);
        try {
            this.roomService.addRoom(room);
            System.out.println(room);
        }catch (Exception e){
            model.addAttribute("log","房间编号重复！请检查后添加！");
            List<Room> rooms = this.roomService.queryAllRoom(new Room());
            model.addAttribute("rooms",rooms);
            return "room_manager";
        }

        model.addAttribute("log","添加成功！");
        List<Room> rooms = this.roomService.queryAllRoom(new Room());
        model.addAttribute("rooms",rooms);
        return "room_manager";
    }

    //查询
    @RequestMapping(path = "/showList",method = {RequestMethod.GET,RequestMethod.POST})
    public String showList(Model model, Room room) {
        if (room == null) {
            room = new Room();
        }
        List<Room> rooms = this.roomService.queryAllRoom(room);
        model.addAttribute("rooms", rooms);
        if(rooms.isEmpty()){
            model.addAttribute("log","无此房间！");
        }else{
            model.addAttribute("log","查询成功！");
        }
        return "room_manager";
    }

    /*@GetMapping(path = "/showInfo")
    public String showInfo(Integer roomId, Model model){
        System.out.println("需要查询的部门编号是：" + roomId);
        Room room = this.roomService.queryRoomByRoomId(roomId);
        model.addAttribute("room", room);
        System.out.println(room);
        return "roomInfo";
    }*/

    @GetMapping(path = "/preupdate/{rid}")
    public String preUpdate(@PathVariable("rid") Integer rid, Model model){
        System.out.println("当前需要修改信息的房间是：" + rid);

        Room room = this.roomService.queryRoomByRoomId(rid);

        model.addAttribute("room", room);

        return "update_room";
    }

    @PostMapping(path = "/update")
    public String updateDept(Room room, Model model){
        System.out.println("更改后的信息是：" + room);
        this.roomService.updateRoom(room);
        List<Room> rooms = this.roomService.queryAllRoom(new Room());
        model.addAttribute("rooms",rooms);
        model.addAttribute("log","修改成功！");
        return "room_manager";
    }

    @RequestMapping(value = "delete/{rid}",method = {RequestMethod.GET})
    public String delete(@PathVariable("rid")Integer rid,Model model){
        System.out.println("需停用的房间编号是：" +rid.toString());
        this.roomService.deleteRoom(rid);
        List<Room> rooms = this.roomService.queryAllRoom(new Room());
        model.addAttribute("rooms",rooms);
        model.addAttribute("log","删除成功！");
        return "room_manager";
    }

}
