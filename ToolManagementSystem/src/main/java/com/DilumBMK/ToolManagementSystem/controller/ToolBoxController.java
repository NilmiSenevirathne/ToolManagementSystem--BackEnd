package com.DilumBMK.ToolManagementSystem.controller;

import com.DilumBMK.ToolManagementSystem.service.ToolBoxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/toolbox")
public class ToolBoxController {

    private final ToolBoxService toolBoxService;

    public ToolBoxController(ToolBoxService toolBoxService) {
        this.toolBoxService = toolBoxService;
    }
}
