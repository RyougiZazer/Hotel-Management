package com.hotel.demo.controller;


import com.hotel.demo.entity.Order;
import com.hotel.demo.entity.Room;
import com.hotel.demo.service.OrderService;
import com.hotel.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setLenient(true);
        dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }

    @GetMapping(path = "/preAdd")
    public String preAdd(Model model){
        Room room = Room.builder().status(1).build(); // 创建出查询的条件 -- 查询所有正在使用中的部门信息
        List<Room> rooms = this.roomService.queryAllRoom(room);
        model.addAttribute("rooms", rooms);
        return "addOrder";
    }

    @PostMapping(path = "/add")
    public String addOrder(Order order){
        System.out.println("新产生的预订是：" + order);
        this.orderService.addOrder(order);
        return "";
    }

}
