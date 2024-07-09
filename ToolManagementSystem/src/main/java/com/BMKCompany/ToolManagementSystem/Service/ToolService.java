package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ToolService {

    @Autowired
    private ToolRepo toolRepo;

    public Tool saveTool(Tool tool)
    {
        return toolRepo.save(tool);
    }

//    public List<Tool> getAllTools() {
//        return toolRepo.findAll();
//    }
    

}
