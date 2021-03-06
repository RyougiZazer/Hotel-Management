package com.hotel.demo.service;

import com.hotel.demo.entity.Emp;

import java.util.List;


public interface EmpService {
    void addEmp(Emp emp);
    String deleteEmp(Integer empId);
    Emp selectEmp(Integer empId);
    void updateEmp(Emp emp);
    List<Emp> queryAllEmps(Emp emp);


}
