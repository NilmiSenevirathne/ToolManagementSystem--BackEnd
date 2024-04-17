package com.DilumBMK.ToolManagementSystem.repository;

import com.DilumBMK.ToolManagementSystem.model.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.tools.Tool;

public interface ToolRepository extends JpaRepository<Tools,String> {

}

