

package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.Tool;
import com.BMKCompany.ToolManagementSystem.model.ToolBox;
import com.BMKCompany.ToolManagementSystem.repository.ToolRepo;
import com.BMKCompany.ToolManagementSystem.repository.ToolboxRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolBoxService {

    @Autowired
    private ToolboxRepo toolboxRepo;

    public ToolBox showToolBox(ToolBox toolBox){
        return  toolboxRepo.save(toolBox);
    }

    public void save(ToolBox toolBox) {
    }


    public Optional<ToolBox> getToolBoxById(String id) {
        return toolboxRepo.findById(String.valueOf(id));
    }

    public void createToolbox(String toolboxId, String projectId, String siteSupervisorId, String locationId, List<String> toolIds) {
        ToolBox toolbox = new ToolBox();
        toolbox.setToolbox_id(toolboxId);
        toolbox.setProject_id(projectId);
        toolbox.setSite_supervisor_id(siteSupervisorId);
        toolbox.setLocation_id(locationId);

        toolboxRepo.save(toolbox);
    }
}

