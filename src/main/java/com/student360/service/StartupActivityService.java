package com.student360.service;

import com.student360.entity.StartupActivity;
import com.student360.entity.Student;
import com.student360.repository.StartupActivityRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StartupActivityService {

    private final StartupActivityRepository startupActivityRepository;
    private final StudentRepository studentRepository;

    public StartupActivityService(
            StartupActivityRepository startupActivityRepository,
            StudentRepository studentRepository) {

        this.startupActivityRepository = startupActivityRepository;
        this.studentRepository = studentRepository;
    }

    public StartupActivity saveStartupActivity(
            StartupActivity startupActivity) {

        Student student = studentRepository.findById(
                        startupActivity.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        startupActivity.setStudent(student);

        return startupActivityRepository.save(startupActivity);
    }

    public List<StartupActivity> getAllStartupActivities() {
        return startupActivityRepository.findAll();
    }

    public List<StartupActivity> getStartupActivitiesByStudentId(
            Long studentId) {

        return startupActivityRepository.findByStudentId(studentId);
    }
}