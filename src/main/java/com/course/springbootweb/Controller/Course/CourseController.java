package com.course.springbootweb.Controller.Course;

import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CourseController  {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public String list(Model model){
        List<Course> list=courseRepository.findAll();
        model.addAttribute("courses",list);
        return "course/list";
    }
}
