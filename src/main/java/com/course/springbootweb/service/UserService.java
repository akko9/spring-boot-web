package com.course.springbootweb.service;

import com.course.springbootweb.Entity.User;
import com.course.springbootweb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  {
    @Autowired
    UserRepository userRepository;

    public User findByNameAndPassword(String name,String password){
        User user=userRepository.findByNameAndPassword(name,password);
        return user;
    }
    /*
    查找所有对象
     */
    public List<User> findAll(){
        List<User> users=userRepository.findAll();
        return users;
    }
    /*
    添加
     */
    public void insert(User user){
        userRepository.save(user);
    }
    /*
    通过id查找对象
     */
    public User findById(Integer id){
        User user=userRepository.findById(id).get();
        return user;
    }
    /*
    更新
     */
    public void update(User user){
        userRepository.save(user);
    }
    /*
    删除
     */
    public void delete(User user){
        userRepository.delete(user);
    }
}
