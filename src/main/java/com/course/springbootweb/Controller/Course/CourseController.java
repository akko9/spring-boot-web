package com.course.springbootweb.Controller.Course;

import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.repository.CourseRepository;
import com.course.springbootweb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CourseController  {

    @Autowired
    CourseService courseService;
    @ResponseBody
    @GetMapping("/listCourses")
    public List<Course> list(Model model){
        List<Course> list=courseService.findAll();
        model.addAttribute("courses",list);
        return list;
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
