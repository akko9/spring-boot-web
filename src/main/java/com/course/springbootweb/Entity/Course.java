package com.course.springbootweb.Entity;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(length = 50)
    private  String name;
    @Column(length = 50)
    private  Integer level;
    @Column(length = 50)
    private  String  tName;
    @Column(length = 50)
    private  Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tNname) {
        this.tName = tNname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
