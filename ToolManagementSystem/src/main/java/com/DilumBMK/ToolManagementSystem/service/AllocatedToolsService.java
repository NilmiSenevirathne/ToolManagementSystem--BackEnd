package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.AllocatedToolsRepo;
import org.springframework.stereotype.Service;

@Service
public class AllocatedToolsService {

    private final AllocatedToolsRepo allocatedToolsRepo;

    public AllocatedToolsService(AllocatedToolsRepo allocatedToolsRepo) {
        this.allocatedToolsRepo = allocatedToolsRepo;
    }
}
