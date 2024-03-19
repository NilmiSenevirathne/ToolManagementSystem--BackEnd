package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.model.Tools;
import com.DilumBMK.ToolManagementSystem.repository.ToolsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {

    @Autowired
    private final ToolsRepo toolsRepo;

    public ToolsService(ToolsRepo toolsRepo) {
        this.toolsRepo = toolsRepo;
    }

    public Tools saveTools(Tools tools)
    {
        return toolsRepo.save(tools);
    }

    public List<Tools> getAllTools()
    {
        return toolsRepo.findAll();
    }
}
