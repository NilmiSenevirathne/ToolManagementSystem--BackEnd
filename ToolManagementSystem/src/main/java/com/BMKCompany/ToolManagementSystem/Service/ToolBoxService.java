

package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolBoxService {

    @Autowired
    private ToolboxRepo toolboxRepo;

    public ToolBox showToolBox(ToolBox toolBox){
        return  toolboxRepo.save(toolBox);
    }

    public void save(ToolBox toolBox) {
    }




}

