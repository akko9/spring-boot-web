package com.course.springbootweb.Controller.Student;

import com.course.springbootweb.Entity.Student;
import com.course.springbootweb.Entity.User;
import com.course.springbootweb.service.StudentService;
import com.course.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @GetMapping("/student/{id}")
    public String toUpDate(@PathVariable("id") Integer id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/add";
    }
    @GetMapping("/students")
    public String getList(Model model){
        List<Student> students=studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping("/student")
    public String toAdd(){
        return "student/add";
    }
    @PostMapping("/student")
    public String addStudent(Student student){
       String name= student.getUser().getName();
       User userInfo=userService.findByName(name);
        student.setUser(userInfo);
        studentService.insert(student);
        return "redirect:/students";
    }
    @PutMapping("/student")
    public  String upDataStudent(Student student){
        String name= student.getUser().getName();
        User userInfo=userService.findByName(name);
        student.setUser(userInfo);
        studentService.update(student);
        return "redirect:/students";
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id" )Integer id){
        Student student=studentService.findById(id);
        studentService.delete(student);
        return "redirect:/students";
    }

}
