package com.student360.service;

import com.student360.entity.CommunicationSkill;
import com.student360.entity.Student;
import com.student360.repository.CommunicationSkillRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunicationSkillService {

    private final CommunicationSkillRepository communicationSkillRepository;
    private final StudentRepository studentRepository;

    public CommunicationSkillService(
            CommunicationSkillRepository communicationSkillRepository,
            StudentRepository studentRepository) {

        this.communicationSkillRepository = communicationSkillRepository;
        this.studentRepository = studentRepository;
    }

    public CommunicationSkill saveCommunicationSkill(
            CommunicationSkill communicationSkill) {

        Student student = studentRepository.findById(
                        communicationSkill.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        communicationSkill.setStudent(student);

        return communicationSkillRepository.save(communicationSkill);
    }

    public List<CommunicationSkill> getAllCommunicationSkills() {
        return communicationSkillRepository.findAll();
    }

    public List<CommunicationSkill> getCommunicationSkillsByStudentId(
            Long studentId) {

        return communicationSkillRepository.findByStudentId(studentId);
    }
}