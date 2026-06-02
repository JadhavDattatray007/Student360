package com.student360.entity;

import jakarta.persistence.*;

@Entity
public class SportsActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sportName;

    private String level;

    private String achievement;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public SportsActivity() {
    }

    public Long getId() {
        return id;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}