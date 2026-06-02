package com.student360.controller;

import com.student360.entity.StartupActivity;
import com.student360.service.StartupActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/startup-activities")
public class StartupActivityController {

    private final StartupActivityService startupActivityService;

    public StartupActivityController(
            StartupActivityService startupActivityService) {

        this.startupActivityService = startupActivityService;
    }

    @PostMapping
    public StartupActivity addStartupActivity(
            @RequestBody StartupActivity startupActivity) {

        return startupActivityService.saveStartupActivity(startupActivity);
    }

    @GetMapping
    public List<StartupActivity> getAllStartupActivities() {
        return startupActivityService.getAllStartupActivities();
    }

    @GetMapping("/student/{studentId}")
    public List<StartupActivity> getStartupActivitiesByStudentId(
            @PathVariable Long studentId) {

        return startupActivityService
                .getStartupActivitiesByStudentId(studentId);
    }
}