package com.student360.repository;
import java.util.List;

import com.student360.entity.AcademicRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademicRecordRepository
        extends JpaRepository<AcademicRecord, Long> {

    List<AcademicRecord> findByStudentId(Long studentId);
    long countByStudentId(Long studentId);

}