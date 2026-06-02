package com.student360.service;

import com.student360.entity.LeadershipActivity;
import com.student360.entity.Student;
import com.student360.repository.LeadershipActivityRepository;
import com.student360.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadershipActivityService {

    private final LeadershipActivityRepository leadershipActivityRepository;
    private final StudentRepository studentRepository;

    public LeadershipActivityService(
            LeadershipActivityRepository leadershipActivityRepository,
            StudentRepository studentRepository) {

        this.leadershipActivityRepository = leadershipActivityRepository;
        this.studentRepository = studentRepository;
    }

    public LeadershipActivity saveLeadershipActivity(
            LeadershipActivity leadershipActivity) {

        Student student = studentRepository.findById(
                        leadershipActivity.getStudent().getId())
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        leadershipActivity.setStudent(student);

        return leadershipActivityRepository.save(leadershipActivity);
    }

    public List<LeadershipActivity> getAllLeadershipActivities() {
        return leadershipActivityRepository.findAll();
    }

    public List<LeadershipActivity> getLeadershipActivitiesByStudentId(
            Long studentId) {

        return leadershipActivityRepository.findByStudentId(studentId);
    }
}