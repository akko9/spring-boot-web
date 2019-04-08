package com.course.springbootweb.repository;

import com.course.springbootweb.Entity.Student;
import com.course.springbootweb.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByUser(User user);

    int countByLessonOne(String lessonOne);

    int countByLessonTwo(String lessonTwo);

}
