package com.student360.controller;

import com.student360.entity.LeadershipActivity;
import com.student360.service.LeadershipActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leadership-activities")
public class LeadershipActivityController {

    private final LeadershipActivityService leadershipActivityService;

    public LeadershipActivityController(
            LeadershipActivityService leadershipActivityService) {

        this.leadershipActivityService = leadershipActivityService;
    }

    @PostMapping
    public LeadershipActivity addLeadershipActivity(
            @RequestBody LeadershipActivity leadershipActivity) {

        return leadershipActivityService
                .saveLeadershipActivity(leadershipActivity);
    }

    @GetMapping
    public List<LeadershipActivity> getAllLeadershipActivities() {
        return leadershipActivityService.getAllLeadershipActivities();
    }

    @GetMapping("/student/{studentId}")
    public List<LeadershipActivity> getLeadershipActivitiesByStudentId(
            @PathVariable Long studentId) {

        return leadershipActivityService
                .getLeadershipActivitiesByStudentId(studentId);
    }
}