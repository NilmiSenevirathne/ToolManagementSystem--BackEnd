package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository <Tool,String> {
import com.BMKCompany.ToolManagementSystem.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository <Tools,String> {



}
