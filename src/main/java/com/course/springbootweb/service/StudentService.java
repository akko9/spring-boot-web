package com.course.springbootweb.service;

import com.course.springbootweb.Entity.Student;
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
}
