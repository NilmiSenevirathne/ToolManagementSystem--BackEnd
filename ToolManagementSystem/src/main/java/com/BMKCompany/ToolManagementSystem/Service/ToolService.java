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

    //Implement methods in the service class to save tools, allocate tools, and update the quantity values accordingly.
    public Tool allocateTool(Long toolId, int quantitiyToAllocate)
    {
        Tool tool = toolRepo.findById(toolId).orElse(null);

        if(tool !=null && tool.getSavedQuantity() >= quantitiyToAllocate)
        {
            tool.setSavedQuantity(tool.getSavedQuantity() - quantitiyToAllocate);
            return  toolRepo.save(tool);
        }
        else {
            return null;
        }
    }
}
