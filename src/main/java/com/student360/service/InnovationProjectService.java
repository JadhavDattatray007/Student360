package com.student360.service;

import com.student360.entity.InnovationProject;
import com.student360.entity.Student;
import com.student360.repository.InnovationProjectRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InnovationProjectService {

    private final InnovationProjectRepository innovationProjectRepository;
    private final StudentRepository studentRepository;

    public InnovationProjectService(
            InnovationProjectRepository innovationProjectRepository,
            StudentRepository studentRepository) {

        this.innovationProjectRepository = innovationProjectRepository;
        this.studentRepository = studentRepository;
    }

    public InnovationProject saveInnovationProject(
            InnovationProject innovationProject) {

        Student student = studentRepository.findById(
                        innovationProject.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        innovationProject.setStudent(student);

        return innovationProjectRepository.save(innovationProject);
    }

    public List<InnovationProject> getAllInnovationProjects() {
        return innovationProjectRepository.findAll();
    }

    public List<InnovationProject> getInnovationProjectsByStudentId(
            Long studentId) {

        return innovationProjectRepository.findByStudentId(studentId);
    }
}