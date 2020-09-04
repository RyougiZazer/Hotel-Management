package com.hotel.demo.controller;

import com.hotel.demo.entity.Emp;
import com.hotel.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
        return "employee_manager";
    }


    @RequestMapping(value = "delete/{eid}",method = {RequestMethod.GET})
    public String delete(@PathVariable("eid")Integer eid){
        System.out.println("需删除的员工编号是：" +eid.toString());
        this.empService.deleteEmp(eid);
        return "redirect:/employee_manager";
    }

    @GetMapping(path = "/preAdd")
    public String toAdd(){
        return "addEmp";
    }

    @PostMapping(path = "/add")
    public String addEmp(Emp emp){
        System.out.println("新入职的员工信息是：" + emp);
        this.empService.addEmp(emp);
        return "redirect:/emp/showList";
    }

    @GetMapping(path = "/empSelect")
    public String selectEmp(Integer empId, Model model){
        System.out.println("查询的员工编号是：" + empId);
        Emp emp = this.empService.selectEmp(empId);
        model.addAttribute("emp",emp);
        System.out.println(emp);
        return "redirect:/emp/showList";
    }

//    @GetMapping(path = "/deleteEmp/{eid}")
//    public String deleteEmp(@PathVariable("eid")String eid){
//        System.out.println("需删除的员工编号是：" +eid);
//        Integer temp = Integer.getInteger(eid);
//        this.empService.deleteEmp(temp);
//        return "redirect:/employee_manager";
//    }
}
