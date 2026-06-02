package com.student360.controller;

import com.student360.entity.Certification;
import com.student360.service.CertificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/certifications")
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(
            CertificationService certificationService) {

        this.certificationService = certificationService;
    }

    @PostMapping
    public Certification addCertification(
            @RequestBody Certification certification) {

        return certificationService.saveCertification(certification);
    }

    @GetMapping
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/student/{studentId}")
    public List<Certification> getCertificationsByStudentId(
            @PathVariable Long studentId) {

        return certificationService
                .getCertificationsByStudentId(studentId);
    }
}