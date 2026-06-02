package com.student360.service;

import com.student360.entity.AcademicRecord;
import com.student360.repository.AcademicRecordRepository;
import org.springframework.stereotype.Service;
import com.student360.entity.Student;
import com.student360.repository.StudentRepository;

import java.util.List;

@Service
public class AcademicRecordService {

    private final AcademicRecordRepository academicRecordRepository;
    private final StudentRepository studentRepository;

    public AcademicRecordService(
            AcademicRecordRepository academicRecordRepository,
            StudentRepository studentRepository) {

        this.academicRecordRepository = academicRecordRepository;
        this.studentRepository = studentRepository;
    }

    public AcademicRecord saveAcademicRecord(AcademicRecord academicRecord) {

        Student student = studentRepository.findById(
                        academicRecord.getStudent().getId())
                .orElseThrow(() -> new RuntimeException("Student not found"));

        academicRecord.setStudent(student);

        return academicRecordRepository.save(academicRecord);
    }

    public List<AcademicRecord> getAllAcademicRecords() {
        return academicRecordRepository.findAll();
    }

    public List<AcademicRecord> getAcademicRecordsByStudentId(Long studentId) {
        return academicRecordRepository.findByStudentId(studentId);
    }
}