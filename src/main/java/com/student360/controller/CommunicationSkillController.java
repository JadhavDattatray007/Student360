package com.student360.controller;

import com.student360.entity.CommunicationSkill;
import com.student360.service.CommunicationSkillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/communication-skills")
public class CommunicationSkillController {

    private final CommunicationSkillService communicationSkillService;

    public CommunicationSkillController(
            CommunicationSkillService communicationSkillService) {

        this.communicationSkillService = communicationSkillService;
    }

    @PostMapping
    public CommunicationSkill addCommunicationSkill(
            @RequestBody CommunicationSkill communicationSkill) {

        return communicationSkillService
                .saveCommunicationSkill(communicationSkill);
    }

    @GetMapping
    public List<CommunicationSkill> getAllCommunicationSkills() {
        return communicationSkillService.getAllCommunicationSkills();
    }

    @GetMapping("/student/{studentId}")
    public List<CommunicationSkill> getCommunicationSkillsByStudentId(
            @PathVariable Long studentId) {

        return communicationSkillService
                .getCommunicationSkillsByStudentId(studentId);
    }
}