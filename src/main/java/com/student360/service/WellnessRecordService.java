package com.student360.service;

import com.student360.entity.Student;
import com.student360.entity.WellnessRecord;
import com.student360.repository.StudentRepository;
import com.student360.repository.WellnessRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WellnessRecordService {

    private final WellnessRecordRepository wellnessRecordRepository;
    private final StudentRepository studentRepository;

    public WellnessRecordService(
            WellnessRecordRepository wellnessRecordRepository,
            StudentRepository studentRepository) {

        this.wellnessRecordRepository = wellnessRecordRepository;
        this.studentRepository = studentRepository;
    }

    public WellnessRecord saveWellnessRecord(
            WellnessRecord wellnessRecord) {

        Student student = studentRepository.findById(
                        wellnessRecord.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        wellnessRecord.setStudent(student);

        return wellnessRecordRepository.save(wellnessRecord);
    }

    public List<WellnessRecord> getAllWellnessRecords() {
        return wellnessRecordRepository.findAll();
    }

    public List<WellnessRecord> getWellnessRecordsByStudentId(
            Long studentId) {

        return wellnessRecordRepository.findByStudentId(studentId);
    }
}