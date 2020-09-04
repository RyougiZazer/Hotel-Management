package com.hotel.demo.service.impl;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.mapper.EmpMapper;
import com.hotel.demo.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("empService")
public class EmpServiceImpl implements EmpService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public void addEmp(Emp emp) {
        this.empMapper.insertEmp(emp);
    }

    @Override
    public String deleteEmp(Integer empId){
        Emp emp = this.empMapper.selectEmp(empId);
        String msg="success";
        if(emp==null)
            msg="无此员工,无法删除";
        return msg;
    }

    @Override
    public Emp selectEmp(Integer empId){
        return this.empMapper.selectEmp(empId);
    }

    @Override
    public List<Emp> queryAllEmps(Emp emp){
        return  this.empMapper.selectAllEmps(emp);
    }
}
