package com.hotel.demo.controller;

import com.hotel.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.Map;
import com.hotel.demo.entity.User;


@Controller
public class ThymeleafController {

    @Autowired
    private UserService userService;

    private User currentUser;

    @GetMapping(path = "/")
    public String redirect(){
        return "redirect:login";
    }

    @GetMapping(path = "/login")
    public String login(){
        return "login";
    }


    @PostMapping(path = "/login")
    public String doLogin(@RequestParam Map<String,String> parm, Model model){
        this.currentUser = new User(parm.get("username"),parm.get("password"),0);
        System.out.println("User "+ currentUser.getUsername() +" try to login!!!!!");
        User temp = userService.selectUser(currentUser.getUsername());
        if(temp == null){
            model.addAttribute("error","用户不存在！");
            currentUser = null;
            return "login";
        }else{
            if (currentUser.getPassword().equals(temp.getPassword())){
                return "redirect:index";
            }else{
                model.addAttribute("error","密码错误!");
                currentUser = null;
                return "login";
            }
        }
    }

    @GetMapping(path = "/index")
    public String index(Model model){
        model.addAttribute("info",currentUser.getUsername());
        Date currentTime =  new Date();
        model.addAttribute("current",currentTime);
        return "index";
    }

    @GetMapping(path = "/room_manager")
    public String room(){
        return "redirect:room_manager/";
    }

    @GetMapping(path = "/order_manager")
    public String order() {return "redirect:order_manager/";}

    @GetMapping(path = "/employee_manager")
    public String employee(){
        return "redirect:employee_manager/";
    }


}
