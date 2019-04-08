package com.course.springbootweb.Controller.Student;

import com.course.springbootweb.Entity.Course;
import com.course.springbootweb.Entity.Student;
import com.course.springbootweb.Entity.User;
import com.course.springbootweb.service.CourseService;
import com.course.springbootweb.service.StudentService;
import com.course.springbootweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;
    @Autowired
    UserService userService;

    @GetMapping("/student/{id}")
    public String toUpDate(@PathVariable("id") Integer id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "/student/add";
    }
    @GetMapping("/students")
    public String getList(Model model){
        List<Student> students=studentService.findAll();
        model.addAttribute("students",students);
        return "student/list";
    }
    @GetMapping("/student")
    public String toAdd(){
        return "student/add";
    }
    @PostMapping("/student")
    public String addStudent(Student student){
       String name= student.getUser().getName();
       User userInfo=userService.findByName(name);
        student.setUser(userInfo);
        studentService.insert(student);
        return "redirect:/students";
    }
    @PutMapping("/student")
    public  String upDataStudent(Student student){
        String name= student.getUser().getName();
        User userInfo=userService.findByName(name);
        student.setUser(userInfo);
        studentService.update(student);
        return "redirect:/students";
    }
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable("id" )Integer id){
        Student student=studentService.findById(id);
        studentService.delete(student);
        return "redirect:/students";
    }
    @GetMapping("/CourseC")
    public String courseC(Model model, HttpSession session){
        String uid=session.getAttribute("uid").toString();
        Integer id=Integer.parseInt(uid);
        User user=userService.findById(id);
        Integer i=user.getNo();
        String sLevel=String.valueOf(i);
        String strLevel=sLevel.substring(0,2);
        Integer level=Integer.parseInt(strLevel);
        List<Course> list=courseService.findAllByNo(level);
        Student studentInfo= studentService.findByUId(user);
        System.out.println("学生信息"+studentInfo);
        if (user.getIsadmin()==0){
            List<Course> list1=courseService.findAll();
            model.addAttribute("courses",list1);
            return "choose";
        }else {
            if (studentInfo==null){
                Student student1=new Student();
                student1.setUser(user);
                System.out.println(student1.getUser());
                studentService.insert(student1);
            }
            model.addAttribute("courses",list);
            return "choose";
        }


    }
    @ResponseBody
    @GetMapping("/studentJson/{id}")
    public Student findStudentById(@PathVariable("id") Integer id){
        Student student=studentService.findById(id);
        return student;
    }
    @ResponseBody
    @PostMapping("/jsonUpdate/{cid}")
    public Student jsonUpdate(@PathVariable("cid") Integer cid,HttpSession session){
        Course course=courseService.findById(cid);
        String uid=session.getAttribute("uid").toString();
        System.out.println("学生编号"+uid);
        Integer id=Integer.parseInt(uid);
        User user=userService.findById(id);
        Student studentInfo=studentService.findByUId(user);
        System.out.println("学生信息:"+studentInfo);
        String lesson1=studentInfo.getLessonOne();
        System.out.println(lesson1);
        String lesson2=studentInfo.getLessonTwo();
        System.out.println(lesson2);
        if (lesson1==null&&lesson2==null){
             studentInfo.setLessonOne(course.getName());
             studentService.insert(studentInfo );
             return studentInfo;
        }else if (lesson1==null){
            studentInfo.setLessonOne(course.getName());
            studentService.insert(studentInfo);
            return studentInfo;

        }else if (lesson2==null){
            studentInfo.setLessonTwo(course.getName());
            studentService.insert(studentInfo);
            return studentInfo;
        }
    return null;
    }
    @ResponseBody
    @GetMapping("/studentInfoJson/{sid}")
    public Student findStudentInfoById(@PathVariable("sid") Integer id){
       User user= userService.findById(id);
       Student student=studentService.findByUId(user);
        return student;
    }
    @ResponseBody
    @PostMapping("/deleteStudentInfo/{cid}")
    public Student deleteJson(@PathVariable("cid") Integer cid,HttpSession session){
        Course course=courseService.findById(cid);
       String courseName=course.getName();
        String uid=session.getAttribute("uid").toString();
       Integer id=Integer.parseInt(uid);
        User user=userService.findById(id);
        System.out.println(user.getName());
        Student studentInfo=studentService.findByUId(user);
        String lesson1=studentInfo.getLessonOne();
        String lesson2=studentInfo.getLessonTwo();
        System.out.println(studentInfo.getLessonOne());
        if (lesson1.equals(courseName)){
            studentInfo.setLessonOne(null);
            studentService.update(studentInfo);
            return studentInfo;
        }else if (lesson2.equals(courseName)){
            studentInfo.setLessonTwo(null);
            studentService.update(studentInfo);
            return studentInfo;
        }
        return null;
    }
    @ResponseBody
    @GetMapping("/count/{cid}")
    public  Integer count(@PathVariable("cid") Integer cid){
        Course course=courseService.findById(cid);
        String lesson= course.getName();
        int count1=studentService.countOne(lesson);
        int count2=studentService.countTwo(lesson);
        int countAll=count1+count2;
        return  countAll;
    }
}
