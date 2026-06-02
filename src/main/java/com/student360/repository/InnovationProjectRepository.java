package com.student360.repository;

import com.student360.entity.InnovationProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InnovationProjectRepository
        extends JpaRepository<InnovationProject, Long> {

    List<InnovationProject> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}