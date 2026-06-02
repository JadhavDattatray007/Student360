package com.student360.controller;

import com.student360.entity.InnovationProject;
import com.student360.service.InnovationProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/innovation-projects")
public class InnovationProjectController {

    private final InnovationProjectService innovationProjectService;

    public InnovationProjectController(
            InnovationProjectService innovationProjectService) {

        this.innovationProjectService = innovationProjectService;
    }

    @PostMapping
    public InnovationProject addInnovationProject(
            @RequestBody InnovationProject innovationProject) {

        return innovationProjectService
                .saveInnovationProject(innovationProject);
    }

    @GetMapping
    public List<InnovationProject> getAllInnovationProjects() {
        return innovationProjectService.getAllInnovationProjects();
    }

    @GetMapping("/student/{studentId}")
    public List<InnovationProject> getInnovationProjectsByStudentId(
            @PathVariable Long studentId) {

        return innovationProjectService
                .getInnovationProjectsByStudentId(studentId);
    }
}