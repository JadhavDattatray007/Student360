package com.student360.repository;

import com.student360.entity.StartupActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StartupActivityRepository
        extends JpaRepository<StartupActivity, Long> {

    List<StartupActivity> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}