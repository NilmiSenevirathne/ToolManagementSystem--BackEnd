package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.ProjectsRepo;
import org.springframework.stereotype.Service;

@Service
public class ProjectsService {

     private final ProjectsRepo projectsRepo;

    public ProjectsService(ProjectsRepo projectsRepo) {
        this.projectsRepo = projectsRepo;
    }
}
