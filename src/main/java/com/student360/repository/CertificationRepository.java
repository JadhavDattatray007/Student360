package com.student360.repository;

import com.student360.entity.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository
        extends JpaRepository<Certification, Long> {

    List<Certification> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);

}