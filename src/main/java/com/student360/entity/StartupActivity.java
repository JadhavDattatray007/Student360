package com.student360.entity;

import jakarta.persistence.*;

@Entity
public class StartupActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startupName;

    private String ideaDomain;

    private String status;

    private String achievement;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public StartupActivity() {
    }

    public Long getId() {
        return id;
    }

    public String getStartupName() {
        return startupName;
    }

    public void setStartupName(String startupName) {
        this.startupName = startupName;
    }

    public String getIdeaDomain() {
        return ideaDomain;
    }

    public void setIdeaDomain(String ideaDomain) {
        this.ideaDomain = ideaDomain;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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