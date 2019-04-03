package com.course.springbootweb.service;



import com.course.springbootweb.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService  {
    @Autowired
    CourseRepository courseRepository;

}
