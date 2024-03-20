package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.ToolBoxRepo;
import org.springframework.stereotype.Service;

@Service
public class ToolBoxService {

    private final ToolBoxRepo toolBoxRepo;

    public ToolBoxService(ToolBoxRepo toolBoxRepo) {
        this.toolBoxRepo = toolBoxRepo;
    }
}
