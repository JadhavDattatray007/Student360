package com.student360.service;

import com.student360.entity.SportsActivity;
import com.student360.entity.Student;
import com.student360.repository.SportsActivityRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsActivityService {

    private final SportsActivityRepository sportsActivityRepository;
    private final StudentRepository studentRepository;

    public SportsActivityService(
            SportsActivityRepository sportsActivityRepository,
            StudentRepository studentRepository) {

        this.sportsActivityRepository = sportsActivityRepository;
        this.studentRepository = studentRepository;
    }

    public SportsActivity saveSportsActivity(
            SportsActivity sportsActivity) {

        Student student = studentRepository.findById(
                        sportsActivity.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        sportsActivity.setStudent(student);

        return sportsActivityRepository.save(sportsActivity);
    }

    public List<SportsActivity> getAllSportsActivities() {
        return sportsActivityRepository.findAll();
    }

    public List<SportsActivity> getSportsActivitiesByStudentId(
            Long studentId) {

        return sportsActivityRepository.findByStudentId(studentId);
    }
}