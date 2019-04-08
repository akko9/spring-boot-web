package com.course.springbootweb.Controller.Course;

import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.Entity.User;
import com.course.springbootweb.service.CourseService;
import com.course.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController  {

    @Autowired
    CourseService courseService;
    @Autowired
    UserService userService;
    @ResponseBody
    @GetMapping("/listCourses/{uid}")
    public List<Course> list(@PathVariable("uid") Integer id){
        User user=userService.findById(id);
        Integer  isAdmin=user.getIsadmin();
        System.out.println("管理权限为"+isAdmin);
        if (isAdmin==0){
            List<Course> list=courseService.findAll();
            return list;
        }else if(isAdmin==1){
            Integer i=user.getNo();
            String sLevel=String.valueOf(i);
            String strLevel=sLevel.substring(0,2);
            Integer level=Integer.parseInt(strLevel);
            List<Course> list=courseService.findAllByNo(level);
            return list;
        }
        return null;
    }

    @PostMapping("/course")
    public String addCourse(Course course){
        courseService.insert(course);
        return "redirect:/courses";
    }
    @PutMapping("/course")
    public String upDate(Course course){
        courseService.update(course);
        return "redirect:/courses";
    }
    @DeleteMapping("/course/{id}")
    public String delete(@PathVariable("id") Integer id){
        Course course=courseService.findById(id);
        courseService.delete(course);
        return "redirect:/courses";
    }


}
