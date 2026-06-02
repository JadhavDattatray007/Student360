package com.student360.repository;

import com.student360.entity.LeadershipActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeadershipActivityRepository
        extends JpaRepository<LeadershipActivity, Long> {

    List<LeadershipActivity> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}