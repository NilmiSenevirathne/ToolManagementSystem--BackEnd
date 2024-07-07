package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.ToolBoxStatus;
import com.BMKCompany.ToolManagementSystem.model.ToolBoxTool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolBoxStatusRepository extends JpaRepository<ToolBoxStatus,Long> {
}
