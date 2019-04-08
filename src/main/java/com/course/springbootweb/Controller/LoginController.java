package com.course.springbootweb.Controller;

import com.course.springbootweb.Entity.User;
import com.course.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){
        User user=userService.findByNameAndPassword(username,password);
        if (user!=null){
            //重定向
            session.setAttribute("loginUser",username);
            session.setAttribute("uid",user.getId());
            session.setAttribute("isAdmin",user.getIsadmin());
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码不正确");
            return "index";
        }

    }
    @GetMapping ("/user/signOut")
    public String signOut(HttpSession session){
        session.removeAttribute("loginUser");
        return "redirect:/index.html";
    }
    @GetMapping("/moban")
    public String moban(){
        return "/moban";
    }
}
