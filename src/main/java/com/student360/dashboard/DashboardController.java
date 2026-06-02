package com.student360.dashboard;

import com.student360.dto.StudentDashboardDTO;
import com.student360.entity.Student;
import com.student360.repository.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final StudentRepository studentRepository;
    private final AcademicRecordRepository academicRecordRepository;
    private final SportsActivityRepository sportsActivityRepository;
    private final CertificationRepository certificationRepository;
    private final LeadershipActivityRepository leadershipActivityRepository;
    private final InnovationProjectRepository innovationProjectRepository;
    private final CommunicationSkillRepository communicationSkillRepository;

    public DashboardController(
            StudentRepository studentRepository,
            AcademicRecordRepository academicRecordRepository,
            SportsActivityRepository sportsActivityRepository,
            CertificationRepository certificationRepository,
            LeadershipActivityRepository leadershipActivityRepository,
            InnovationProjectRepository innovationProjectRepository,
            CommunicationSkillRepository communicationSkillRepository) {

        this.studentRepository = studentRepository;
        this.academicRecordRepository = academicRecordRepository;
        this.sportsActivityRepository = sportsActivityRepository;
        this.certificationRepository = certificationRepository;
        this.leadershipActivityRepository = leadershipActivityRepository;
        this.innovationProjectRepository = innovationProjectRepository;
        this.communicationSkillRepository = communicationSkillRepository;
    }

    @GetMapping("/student/{studentId}")
    public StudentDashboardDTO getDashboard(
            @PathVariable Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        StudentDashboardDTO dto = new StudentDashboardDTO();

        dto.setStudentName(student.getName());

        dto.setAcademicRecords(
                (int) academicRecordRepository.countByStudentId(studentId));

        dto.setSportsActivities(
                (int) sportsActivityRepository.countByStudentId(studentId));

        dto.setCertifications(
                (int) certificationRepository.countByStudentId(studentId));

        dto.setLeadershipActivities(
                (int) leadershipActivityRepository.countByStudentId(studentId));

        dto.setInnovationProjects(
                (int) innovationProjectRepository.countByStudentId(studentId));

        dto.setCommunicationSkills(
                (int) communicationSkillRepository.countByStudentId(studentId));

        return dto;
    }
}