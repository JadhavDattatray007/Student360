package com.student360.controller;

import com.student360.entity.AcademicRecord;
import com.student360.service.AcademicRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/academic-records")
public class AcademicRecordController {

    private final AcademicRecordService academicRecordService;

    public AcademicRecordController(AcademicRecordService academicRecordService) {
        this.academicRecordService = academicRecordService;
    }

    @PostMapping
    public AcademicRecord addAcademicRecord(
            @RequestBody AcademicRecord academicRecord) {

        return academicRecordService.saveAcademicRecord(academicRecord);
    }

    @GetMapping
    public List<AcademicRecord> getAllAcademicRecords() {
        return academicRecordService.getAllAcademicRecords();
    }

    @GetMapping("/student/{studentId}")
    public List<AcademicRecord> getAcademicRecordsByStudentId(
            @PathVariable Long studentId) {

        return academicRecordService.getAcademicRecordsByStudentId(studentId);
    }
}