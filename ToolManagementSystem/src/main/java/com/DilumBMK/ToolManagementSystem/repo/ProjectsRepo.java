package com.DilumBMK.ToolManagementSystem.repo;

import com.DilumBMK.ToolManagementSystem.Entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepo extends JpaRepository <Projects , String>{
}
