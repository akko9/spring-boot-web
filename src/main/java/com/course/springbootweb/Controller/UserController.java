package com.course.springbootweb.Controller;

import com.course.springbootweb.Entity.User;
import com.course.springbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/users")
    public String list(Model model){
        List<User> list=userRepository.findAll();
        model.addAttribute("users",list);
        return "user/list";
    }
    @GetMapping("/user")
    public String toAddUser(){
      return "user/add";
    }
    @PostMapping("/user")
    public String addUser(User user){
        System.out.println(user);
        userRepository.save(user);
        return "redirect:/users";
    }
    @GetMapping("/user/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        System.out.println(id);
        User user= userRepository.findById(id).get();
        model.addAttribute("user",user);
        return "user/add";
    }
    @PutMapping("/user")
    public String updateUser(User user){
        User userInfo= userRepository.findById(user.getId()).get();
        user.setId(userInfo.getId());
        userRepository.save(user);
        return "redirect:/users";
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println(id);
        User user= userRepository.findById(id).get();
        userRepository.delete(user);
        return "redirect:/users";
    }
}
