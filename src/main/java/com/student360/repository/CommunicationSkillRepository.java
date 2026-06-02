package com.student360.repository;

import com.student360.entity.CommunicationSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunicationSkillRepository
        extends JpaRepository<CommunicationSkill, Long> {

    List<CommunicationSkill> findByStudentId(Long studentId);

    long countByStudentId(Long studentId);
}