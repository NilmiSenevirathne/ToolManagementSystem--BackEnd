package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.Entity.Tools;
import com.DilumBMK.ToolManagementSystem.repo.ToolsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolsService  {

        public ToolsService(ToolsRepo toolsRepo) {

        this.toolsRepo = toolsRepo;
    }



    @Autowired
    private final ToolsRepo toolsRepo;
    public Tools saveTools(Tools tools){

        return toolsRepo.save(tools);
    }




}
