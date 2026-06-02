package com.student360.score;

import com.student360.entity.Student;
import com.student360.repository.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/score")
public class ScoreController {

    private final StudentRepository studentRepository;
    private final AcademicRecordRepository academicRecordRepository;
    private final SportsActivityRepository sportsActivityRepository;
    private final CertificationRepository certificationRepository;
    private final LeadershipActivityRepository leadershipActivityRepository;
    private final InnovationProjectRepository innovationProjectRepository;
    private final CommunicationSkillRepository communicationSkillRepository;
    private final NSSActivityRepository nssActivityRepository;
    private final WellnessRecordRepository wellnessRecordRepository;
    private final StartupActivityRepository startupActivityRepository;

    public ScoreController(
            StudentRepository studentRepository,
            AcademicRecordRepository academicRecordRepository,
            SportsActivityRepository sportsActivityRepository,
            CertificationRepository certificationRepository,
            LeadershipActivityRepository leadershipActivityRepository,
            InnovationProjectRepository innovationProjectRepository,
            CommunicationSkillRepository communicationSkillRepository,
            NSSActivityRepository nssActivityRepository,
            WellnessRecordRepository wellnessRecordRepository,
            StartupActivityRepository startupActivityRepository) {

        this.studentRepository = studentRepository;
        this.academicRecordRepository = academicRecordRepository;
        this.sportsActivityRepository = sportsActivityRepository;
        this.certificationRepository = certificationRepository;
        this.leadershipActivityRepository = leadershipActivityRepository;
        this.innovationProjectRepository = innovationProjectRepository;
        this.communicationSkillRepository = communicationSkillRepository;
        this.nssActivityRepository = nssActivityRepository;
        this.wellnessRecordRepository = wellnessRecordRepository;
        this.startupActivityRepository = startupActivityRepository;
    }

    @GetMapping("/student/{studentId}")
    public HolisticScoreDTO getScore(
            @PathVariable Long studentId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        int score = 0;

        if (academicRecordRepository.countByStudentId(studentId) > 0)
            score += 20;

        if (sportsActivityRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (certificationRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (leadershipActivityRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (innovationProjectRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (communicationSkillRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (nssActivityRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (wellnessRecordRepository.countByStudentId(studentId) > 0)
            score += 10;

        if (startupActivityRepository.countByStudentId(studentId) > 0)
            score += 10;

        String grade;

        if (score >= 90)
            grade = "A+";
        else if (score >= 80)
            grade = "A";
        else if (score >= 70)
            grade = "B";
        else if (score >= 60)
            grade = "C";
        else
            grade = "D";

        HolisticScoreDTO dto = new HolisticScoreDTO();

        dto.setStudentName(student.getName());
        dto.setScore(score);
        dto.setGrade(grade);

        return dto;
    }
}