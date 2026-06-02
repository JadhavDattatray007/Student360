package com.student360.controller;

import com.student360.entity.SportsActivity;
import com.student360.service.SportsActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sports-activities")
public class SportsActivityController {

    private final SportsActivityService sportsActivityService;

    public SportsActivityController(
            SportsActivityService sportsActivityService) {

        this.sportsActivityService = sportsActivityService;
    }

    @PostMapping
    public SportsActivity addSportsActivity(
            @RequestBody SportsActivity sportsActivity) {

        return sportsActivityService
                .saveSportsActivity(sportsActivity);
    }

    @GetMapping
    public List<SportsActivity> getAllSportsActivities() {
        return sportsActivityService.getAllSportsActivities();
    }

    @GetMapping("/student/{studentId}")
    public List<SportsActivity> getSportsActivitiesByStudentId(
            @PathVariable Long studentId) {

        return sportsActivityService
                .getSportsActivitiesByStudentId(studentId);
    }
}