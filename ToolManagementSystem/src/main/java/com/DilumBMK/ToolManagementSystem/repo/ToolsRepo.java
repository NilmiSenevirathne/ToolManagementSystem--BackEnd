package com.DilumBMK.ToolManagementSystem.repo;

import com.DilumBMK.ToolManagementSystem.Entity.Tools;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolsRepo extends JpaRepository <Tools , String> {

}
