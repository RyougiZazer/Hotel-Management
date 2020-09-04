package com.hotel.demo.controller;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employee_manager")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping(path = "/showList", method = {RequestMethod.GET, RequestMethod.POST})
    public String showList(Model model, Emp emp) {
        if (emp == null) {
            emp = new Emp();
        }
        List<Emp> emps = this.empService.queryAllEmps(emp);
        model.addAttribute("emps", emps);
        System.out.println(emps.get(0).getEname());
        return "employee_manager";
    }

    @GetMapping(path = "/preAdd")
    public String toAdd(){
        return "addEmp";
    }

    @PostMapping(path = "/add")
    public String addEmp(Emp emp){
        System.out.println("新入职的员工信息是：" + emp);
        this.empService.addEmp(emp);
        return "redirect:employee_manager";
    }

    @GetMapping(path = "/empSelect")
    public String selectEmp(Integer empId, Model model){
        System.out.println("查询的员工编号是：" + empId);
        Emp emp = this.empService.selectEmp(empId);
        model.addAttribute("emp",emp);
        System.out.println(emp);
        return "redirect:employee_manager";
    }

    @GetMapping(path = "/deleteEmp/{eid}")
    public String deleteEmp(@PathVariable("eid")Integer empId, Model model){
        System.out.println("需删除的员工编号是：" + empId);
        return this.empService.deleteEmp(empId);
    }

    @GetMapping(path = "/preUpdate/{eid}")
    public String preUpdate(@PathVariable("eid") Integer eid, Model model){
        System.out.println("需要修改信息员工编号为：" + eid);

        Emp emp = this.empService.selectEmp(eid);

        model.addAttribute("emp", emp);

        return "updateEmp";
    }

    @PostMapping(path = "/update")
    public String updateDept(Emp emp){
        System.out.println("更改后的信息是：" + emp);
        this.empService.updateEmp(emp);
        return "redirect:employee_manager";
    }
}
