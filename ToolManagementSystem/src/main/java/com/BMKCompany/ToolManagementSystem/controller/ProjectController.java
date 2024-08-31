package com.BMKCompany.ToolManagementSystem.controller;
import com.BMKCompany.ToolManagementSystem.Exception.ProjectNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Project;
import com.BMKCompany.ToolManagementSystem.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepo projectRepository;

    @PostMapping("/project")
    public ResponseEntity<String> newProject(@RequestBody Project newProject) {
        if (projectRepository.existsById(newProject.getProjectId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Project ID already exists");
        }
        projectRepository.save(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body("Project created successfully");
    }

    @GetMapping("/Projects")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/Projects/{projectId}")
    public Project getProjectById(@PathVariable String projectId) {
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @PutMapping("/Projects/{projectId}")
    public Project updateProject(@RequestBody Project newProject, @PathVariable String projectId) {
        return projectRepository.findById(projectId)
                .map(project -> {
                    project.setProjectId(newProject.getProjectId());
                    project.setProjectName(newProject.getProjectName());
                    project.setDescription(newProject.getDescription());
                    project.setSiteSupervisorID(newProject.getSiteSupervisorID());
                    project.setSiteSupervisorName(newProject.getSiteSupervisorName());
                    project.setLocationId(newProject.getLocationId());
                    project.setStartDate(newProject.getStartDate());
                    project.setEndDate(newProject.getEndDate());
                    return projectRepository.save(project);
                }).orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @DeleteMapping("/Projects/{projectId}")
    public String deleteProject(@PathVariable String projectId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ProjectNotFoundException(projectId);
        }
        projectRepository.deleteById(projectId);
        return "Project with id " + projectId + " has been deleted successfully";
    }
}