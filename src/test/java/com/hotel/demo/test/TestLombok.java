package com.hotel.demo.test;

import com.hotel.demo.entity.Emp;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class TestLombok {

    @Test
    public void test(){
        Emp emp=new Emp();
        emp.setEmpId(1);
        emp.setEmpName("Peko");
        emp.setGender(0);
        emp.setHireDate(new Date());
        emp.setDeptName("FoodHouse");

        System.out.println(emp);
    }
}
