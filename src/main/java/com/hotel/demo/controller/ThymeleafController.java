package com.hotel.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;
import com.hotel.demo.entity.User;


@Controller
public class ThymeleafController {

    @GetMapping(path = "/")
    public String login(){
        return "login";
    }


    @PostMapping(path = "/index")
    public String index(@RequestParam Map<String,String> parm, Model model, HttpSession session){

        User currentUser = new User(parm.get("username"),parm.get("password"));
        Date current = new Date();
        System.out.println("User "+ currentUser.getUsername() +" try to login!!!!!");


        model.addAttribute("info",parm.get("username"));
        model.addAttribute("current",current);
        return "index";
    }

    @GetMapping(path = "/room_manager")
    public String register(){
        return "room_manager";
    }

}
