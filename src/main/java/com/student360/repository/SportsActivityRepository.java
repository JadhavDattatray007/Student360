package com.student360.repository;

import com.student360.entity.SportsActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportsActivityRepository
        extends JpaRepository<SportsActivity, Long> {

    List<SportsActivity> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);

}