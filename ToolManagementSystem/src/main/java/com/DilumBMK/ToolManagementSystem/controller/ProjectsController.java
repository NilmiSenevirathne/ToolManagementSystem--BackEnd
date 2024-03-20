package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.ProjectsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/projects")
public class ProjectsController {

    private final ProjectsService projectsService;

    public ProjectsController(ProjectsService projectsService) {
        this.projectsService = projectsService;
    }
}
