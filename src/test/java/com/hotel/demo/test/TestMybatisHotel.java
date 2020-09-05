package com.hotel.demo.test;

import com.hotel.demo.DemoApplication;
import com.hotel.demo.entity.Emp;
import com.hotel.demo.entity.Order;
import com.hotel.demo.entity.Room;
import com.hotel.demo.mapper.EmpMapper;
import com.hotel.demo.mapper.OrderMapper;
import com.hotel.demo.mapper.RoomMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {DemoApplication.class})
public class TestMybatisHotel {
    @Resource
    private EmpMapper empMapper;

    @Resource
    private RoomMapper roomMapper;

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void insertTest(){

        Room room = Room.builder().rid(4).rtype(2).status(1).build();
        roomMapper.insertRoom(room);
    }

    @Test
    public void insertOrder(){
        Order order = Order.builder().oid(5).rid(4).number(1).inDate(new Date()).outDate(new Date()).oname("li").ophone("123456").build();
        orderMapper.insertOrder(order);
        /*Emp emp= Emp.builder().eid(1).ename("peko").gender(0).department("foodHouse")
                .hireDate(new Date()).build();
        empMapper.insertEmp(emp);*/
    }

    @Test
    public void selectTest(){
        Emp emp=empMapper.selectEmp(1);
        System.out.println(emp);


    }

    @Test
    public void selectRoom(){
        Room room = roomMapper.selectRoomByRoomId(5);
        System.out.println(room);
    }

    @Test
    public void selectOrder(){
        Order order = orderMapper.selectOrderByOrderId(1);
        System.out.println(order);
    }

    @Test
    public void deleteTest(){
        empMapper.deleteEmp(1);
    }

    @Test
    public void deleteRoom(){
        roomMapper.deleteRoomByRoomId(1);
    }

    @Test
    public void deleteOrder(){
        orderMapper.deleteOrderByOrderId(2);
    }

}
