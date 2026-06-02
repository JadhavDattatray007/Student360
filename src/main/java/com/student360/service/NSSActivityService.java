package com.student360.service;

import com.student360.entity.NSSActivity;
import com.student360.entity.Student;
import com.student360.repository.NSSActivityRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NSSActivityService {

    private final NSSActivityRepository nssActivityRepository;
    private final StudentRepository studentRepository;

    public NSSActivityService(
            NSSActivityRepository nssActivityRepository,
            StudentRepository studentRepository) {

        this.nssActivityRepository = nssActivityRepository;
        this.studentRepository = studentRepository;
    }

    public NSSActivity saveNSSActivity(
            NSSActivity nssActivity) {

        Student student = studentRepository.findById(
                        nssActivity.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        nssActivity.setStudent(student);

        return nssActivityRepository.save(nssActivity);
    }

    public List<NSSActivity> getAllNSSActivities() {
        return nssActivityRepository.findAll();
    }

    public List<NSSActivity> getNSSActivitiesByStudentId(
            Long studentId) {

        return nssActivityRepository.findByStudentId(studentId);
    }
}