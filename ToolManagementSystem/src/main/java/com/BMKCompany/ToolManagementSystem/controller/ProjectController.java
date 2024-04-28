package com.BMKCompany.ToolManagementSystem.controller;
import com.BMKCompany.ToolManagementSystem.Exception.ProjectNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.Project;
import com.BMKCompany.ToolManagementSystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/project")
    Project newProject(@RequestBody Project newProject) {
        return projectRepository.save(newProject);
    }

    @GetMapping("/Projects")
    List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/Projects/{projectId}")
    Project getProjectById(@PathVariable String projectId) {

        return projectRepository.findById(String.valueOf(projectId))
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @PutMapping("/Projects/{projectId}")
    Project upadateProject(@RequestBody Project newProject,@PathVariable String projectId){
        return projectRepository.findById(projectId)
                .map(project -> {

                    project.setProjectId(newProject.getProjectId());
                    project.setProjectName(newProject.getProjectName());
                    project.setDescription(newProject.getDescription());
                    project.setSiteSupervisorID(newProject.getSiteSupervisorID());
                    project.setSiteSupervisorName(newProject.getSiteSupervisorName());
                    project.setLocationId(newProject.getLocationId());
                    return projectRepository.save(project);
                }).orElseThrow(() -> new ProjectNotFoundException(projectId));
    }
    @DeleteMapping("/Projects/{projectId}")
    String DeleteProject(@PathVariable String projectId){
        if(!projectRepository.existsById(projectId)){
            throw new ProjectNotFoundException(projectId);
        }
        projectRepository.deleteById(projectId);
        return "Project with id " +projectId +" has been deleted successfully";
    }


}
