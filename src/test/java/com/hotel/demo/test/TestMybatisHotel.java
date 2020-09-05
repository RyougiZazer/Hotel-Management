package com.hotel.demo.test;

import com.hotel.demo.DemoApplication;
import com.hotel.demo.entity.Emp;
import com.hotel.demo.mapper.EmpMapper;
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

    @Test
    public void insertTest(){
        Emp emp= Emp.builder().eid(1).ename("peko").gender(0).department("foodHouse")
                .hiredate(new Date()).build();
        empMapper.insertEmp(emp);
    }

    @Test
    public void selectTest(){
        Emp emp=empMapper.selectEmp(new Integer(1));
        System.out.println(emp);
    }

    @Test
    public void deleteTest(){
        empMapper.deleteEmp(1);
    }
}
