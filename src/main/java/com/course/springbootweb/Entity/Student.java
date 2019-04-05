package com.course.springbootweb.Entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade=CascadeType.ALL )
    @JoinColumn(name = "sid", referencedColumnName = "id")
    private  User user;
    @Column(length = 50)
    private String lessonOne;
    @Column(length = 50)
    private String lessonTwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLessonOne() {
        return lessonOne;
    }

    public void setLessonOne(String lessonOne) {
        this.lessonOne = lessonOne;
    }

    public String getLessonTwo() {
        return lessonTwo;
    }

    public void setLessonTwo(String lessonTwo) {
        this.lessonTwo = lessonTwo;
    }
}
