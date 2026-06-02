package com.student360.entity;

import jakarta.persistence.*;

@Entity
public class WellnessRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String wellnessType;

    private Integer score;

    private String remarks;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public WellnessRecord() {
    }

    public Long getId() {
        return id;
    }

    public String getWellnessType() {
        return wellnessType;
    }

    public void setWellnessType(String wellnessType) {
        this.wellnessType = wellnessType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}