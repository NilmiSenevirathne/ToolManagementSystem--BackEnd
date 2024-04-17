package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepo extends JpaRepository <Tool,String> {

}