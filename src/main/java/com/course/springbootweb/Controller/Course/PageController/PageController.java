package com.course.springbootweb.Controller.Course.PageController;

import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class PageController {
    @Autowired
    CourseService courseService;
    @GetMapping("/courses")
    public String listCourse(){
        return "course/list";
    }
    @GetMapping("/Course")
    public String toAddCourse(){
        return "course/add";
    }

    @GetMapping("/course/{id}")
    public String toUpDateCourse(@PathVariable("id") Integer id, Model model){
        Course course=courseService.findById(id);
        model.addAttribute("course",course);
        return "course/add";
    }
}
