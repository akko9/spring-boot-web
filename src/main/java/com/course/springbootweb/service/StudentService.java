package com.course.springbootweb.service;

import com.course.springbootweb.Entity.Student;
import com.course.springbootweb.Entity.User;
import com.course.springbootweb.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    /*
    根据id查询对象
     */
    public Student findById(Integer id){
       Student student= studentRepository.findById(id).get();
        return  student;
    }
    /*
    查询所有
     */
    public List<Student> findAll(){
        List<Student> list=studentRepository.findAll();
        return list;
    }
    /*
    添加
     */
    public void insert(Student student){
        studentRepository.save(student);
    }
    /*
    修改
     */
    public void update(Student student){
        studentRepository.save(student);
    }
    /*
    删除
     */
    public void delete(Student student){
        studentRepository.delete(student);
    }
    /*
    根据用户查询student
     */
    public Student findByUId(User user){
        Student student=studentRepository.findByUser(user);
        return  student;
    }
    /*
    根据lesson1 统计
     */
    public Integer countOne(String lessonOne){
         Integer countOne=studentRepository.countByLessonOne(lessonOne);
         return countOne;
    }
    /*
    根据lesson2统计
     */
    public Integer countTwo(String lessonTwo){
        Integer countTwo=studentRepository.countByLessonTwo(lessonTwo);
        return countTwo;
    }
}
