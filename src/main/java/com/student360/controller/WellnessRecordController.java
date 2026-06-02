package com.student360.controller;

import com.student360.entity.WellnessRecord;
import com.student360.service.WellnessRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wellness-records")
public class WellnessRecordController {

    private final WellnessRecordService wellnessRecordService;

    public WellnessRecordController(
            WellnessRecordService wellnessRecordService) {

        this.wellnessRecordService = wellnessRecordService;
    }

    @PostMapping
    public WellnessRecord addWellnessRecord(
            @RequestBody WellnessRecord wellnessRecord) {

        return wellnessRecordService
                .saveWellnessRecord(wellnessRecord);
    }

    @GetMapping
    public List<WellnessRecord> getAllWellnessRecords() {
        return wellnessRecordService.getAllWellnessRecords();
    }

    @GetMapping("/student/{studentId}")
    public List<WellnessRecord> getWellnessRecordsByStudentId(
            @PathVariable Long studentId) {

        return wellnessRecordService
                .getWellnessRecordsByStudentId(studentId);
    }
}