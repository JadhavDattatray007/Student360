package com.student360.repository;

import com.student360.entity.NSSActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NSSActivityRepository
        extends JpaRepository<NSSActivity, Long> {

    List<NSSActivity> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}