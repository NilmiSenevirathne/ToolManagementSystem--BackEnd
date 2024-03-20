package com.DilumBMK.ToolManagementSystem.repo;

import com.DilumBMK.ToolManagementSystem.Entity.ToolBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToolBoxRepo extends JpaRepository <ToolBox, Long> {

}
