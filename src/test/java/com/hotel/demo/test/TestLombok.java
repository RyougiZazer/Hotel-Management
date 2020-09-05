package com.hotel.demo.test;

import com.hotel.demo.entity.Emp;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestLombok {

    @Test
    public void test(){
        Emp emp=new Emp();
        emp.setEid(1);
        emp.setEname("Peko");
        emp.setGender(0);
        emp.setHiredate(new Date());
        emp.setDepartment("FoodHouse");

        System.out.println(emp);
    }
}
