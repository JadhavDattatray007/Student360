package com.student360.service;

import com.student360.entity.Certification;
import com.student360.entity.Student;
import com.student360.repository.CertificationRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;
    private final StudentRepository studentRepository;

    public CertificationService(
            CertificationRepository certificationRepository,
            StudentRepository studentRepository) {

        this.certificationRepository = certificationRepository;
        this.studentRepository = studentRepository;
    }

    public Certification saveCertification(
            Certification certification) {

        Student student = studentRepository.findById(
                        certification.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        certification.setStudent(student);

        return certificationRepository.save(certification);
    }

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public List<Certification> getCertificationsByStudentId(
            Long studentId) {

        return certificationRepository.findByStudentId(studentId);
    }
}