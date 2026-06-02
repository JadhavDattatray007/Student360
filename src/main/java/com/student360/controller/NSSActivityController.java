package com.student360.controller;

import com.student360.entity.NSSActivity;
import com.student360.service.NSSActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nss-activities")
public class NSSActivityController {

    private final NSSActivityService nssActivityService;

    public NSSActivityController(
            NSSActivityService nssActivityService) {

        this.nssActivityService = nssActivityService;
    }

    @PostMapping
    public NSSActivity addNSSActivity(
            @RequestBody NSSActivity nssActivity) {

        return nssActivityService.saveNSSActivity(nssActivity);
    }

    @GetMapping
    public List<NSSActivity> getAllNSSActivities() {
        return nssActivityService.getAllNSSActivities();
    }

    @GetMapping("/student/{studentId}")
    public List<NSSActivity> getNSSActivitiesByStudentId(
            @PathVariable Long studentId) {

        return nssActivityService
                .getNSSActivitiesByStudentId(studentId);
    }
}