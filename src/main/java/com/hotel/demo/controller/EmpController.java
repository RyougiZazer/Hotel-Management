package com.hotel.demo.controller;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/employee_manager")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping(path = "/")
    public String init(Model model){
        List<Emp> emps = this.empService.queryAllEmps(new Emp());
        model.addAttribute("emps",emps);
        return "employee_manager";
    }

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, Emp emp) {
        if (emp == null) {
            emp = new Emp();
        }
        List<Emp> emps = this.empService.queryAllEmps(emp);
        model.addAttribute("emps", emps);
        if(emps.isEmpty()){
            model.addAttribute("log","查无此人！");
        }else{
            model.addAttribute("log","查询成功！");
        }
        return "employee_manager";
    }


    @RequestMapping(value = "delete/{eid}",method = {RequestMethod.GET})
    public String delete(@PathVariable("eid")Integer eid,Model model){
        System.out.println("需删除的员工编号是：" +eid.toString());
        this.empService.deleteEmp(eid);
        List<Emp> emps = this.empService.queryAllEmps(new Emp());
        model.addAttribute("emps",emps);
        model.addAttribute("log","删除成功！");
        return "employee_manager";
    }

    @PostMapping(path = "/add")
    public String addEmp(Emp emp,Model model){
        System.out.println("新入职的员工信息是：" + emp);
        emp.setHiredate(new Date());
        try {
            this.empService.addEmp(emp);
        }catch (Exception e){
            model.addAttribute("log","员工编号重复！请检查后添加！");
            List<Emp> emps = this.empService.queryAllEmps(new Emp());
            model.addAttribute("emps",emps);
            return "employee_manager";
        }

        model.addAttribute("log","添加成功！");
        List<Emp> emps = this.empService.queryAllEmps(new Emp());
        model.addAttribute("emps",emps);
        return "employee_manager";
    }


    @RequestMapping(path = "/preupdate/{eid}",method = {RequestMethod.GET})
    public String preUpdate(@PathVariable("eid") Integer eid, Model model){
        System.out.println("需要修改信息员工编号为：" + eid);
        Emp emp = this.empService.selectEmp(eid);
        model.addAttribute("emp", emp);
        return "update_emp";
    }

    @PostMapping(path = "/update")
    public String updateEmp(Emp emp,Model model){
        System.out.println("更改后的信息是：" + emp);
        emp.setHiredate(new Date());
        this.empService.updateEmp(emp);
        List<Emp> emps = this.empService.queryAllEmps(new Emp());
        model.addAttribute("emps",emps);
        model.addAttribute("log","修改成功！");
        return "employee_manager";
    }

}
