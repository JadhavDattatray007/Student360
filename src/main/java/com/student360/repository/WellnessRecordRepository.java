package com.student360.repository;

import com.student360.entity.WellnessRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WellnessRecordRepository
        extends JpaRepository<WellnessRecord, Long> {

    List<WellnessRecord> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}