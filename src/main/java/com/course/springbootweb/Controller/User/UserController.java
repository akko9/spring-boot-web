package com.course.springbootweb.Controller.User;

import com.course.springbootweb.Entity.User;
import com.course.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    public String list(Model model){
        List<User> list=userService.findAll();
        model.addAttribute("users",list);
        return "user/list";
    }
    @GetMapping("/user")
    public String toAddUser(){
      return "user/add";
    }
    @PostMapping("/user")
    public String addUser(User user){
        user.setIsadmin(1);
        System.out.println(user);
       userService.insert(user);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        System.out.println(id);
        User user= userService.findById(id);
        model.addAttribute("user",user);
        return "user/add";
    }
    @PutMapping("/user")
    public String updateUser(User user){
        userService.update(user);
        return "redirect:/users";
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println(id);
        User user= userService.findById(id);
        userService.delete(user);
        return "redirect:/users";
    }
    @ResponseBody
    @GetMapping("getUserById/{id}")
    public User findUser(@PathVariable("id") Integer id){
        User user= userService.findById(id);
        return user;
    }
}
