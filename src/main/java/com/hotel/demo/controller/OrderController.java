package com.hotel.demo.controller;


import com.hotel.demo.entity.Order;
import com.hotel.demo.service.OrderService;
import com.hotel.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/order_manager")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private RoomService roomService;

    @GetMapping(path = "/")
    public String init(Model model){
        List<Order> orders = this.orderService.queryAllOrders(new Order());
        model.addAttribute("orders",orders);
        return "order_manager";
    }

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, Order order) {
        if (order == null) {
            order = new Order();
        }
        List<Order> orders = this.orderService.queryAllOrders(order);
        model.addAttribute("orders", orders);
        if(orders.isEmpty()){
            model.addAttribute("log","无该订单！");
        }else{
            model.addAttribute("log","查询成功！");
        }
        return "order_manager";
    }


    @RequestMapping(value = "delete/{oid}",method = {RequestMethod.GET})
    public String delete(@PathVariable("oid")Integer oid,Model model){
        System.out.println("需删除的订单编号是：" +oid.toString());
        this.orderService.deleteOrder(oid);
        List<Order> orders = this.orderService.queryAllOrders(new Order());
        model.addAttribute("orders",orders);
        model.addAttribute("log","删除成功！");
        return "order_manager";
    }

    @PostMapping(path = "/add")
    public String addOrder(Order order,Model model){
        System.out.println("新产生的订单是：" + order);
        try {
            this.orderService.addOrder(order);
        }catch (Exception e){
            model.addAttribute("log","订单编号重复！请检查后添加！");
            List<Order> orders = this.orderService.queryAllOrders(new Order());
            model.addAttribute("orders",orders);
            return "order_manager";
        }

        model.addAttribute("log","添加成功！");
        List<Order> orders = this.orderService.queryAllOrders(new Order());
        model.addAttribute("orders",orders);
        return "redirect:/order_manager/showList";
    }

    @GetMapping(path = "/orderSelect")
    public String selectOrder(Integer oid, Model model){
        System.out.println("查询的员工编号是：" + oid);
        Order order = this.orderService.selectOrderByOrderId(oid);
        model.addAttribute("order",order);
        System.out.println(order);
        return "redirect:order_manager";
    }

    @GetMapping(path = "/preUpdate/{eid}")
    public String preUpdate(@PathVariable("oid") Integer oid, Model model){
        System.out.println("需要修改信息订单编号为：" + oid);

        Order order = this.orderService.selectOrderByOrderId(oid);

        model.addAttribute("order", order);

        return "updateOrder";
    }

    @PostMapping(path = "/update")
    public String updateDept(Order order){
        System.out.println("更改后的信息是：" + order);
        this.orderService.updateOrder(order);
        return "redirect:order_manager";
    }
}
