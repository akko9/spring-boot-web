package com.course.springbootweb.service;



import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CourseService  {
    @Autowired
    CourseRepository courseRepository;
    /*
     查找所有
     */
    public List<Course> findAll(){
        List<Course> list=courseRepository.findAll();
        return  list;
    }
    /*
    添加
     */
    public void insert(Course course){
        courseRepository.save(course);
    }
    /*
    通过id查找对象
     */
    public Course findById(Integer id){
        Course course=courseRepository.findById(id).get();
        return course;
    }
    /*
    修改
     */
    public void update(Course course){
        courseRepository.save(course);
    }
    /*
    删除
     */
    public void  delete(Course course){
        courseRepository.delete(course);
    }
}
