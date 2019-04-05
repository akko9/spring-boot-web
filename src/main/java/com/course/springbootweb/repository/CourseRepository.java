package com.course.springbootweb.repository;

import com.course.springbootweb.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findByLevel(Integer level);
}
