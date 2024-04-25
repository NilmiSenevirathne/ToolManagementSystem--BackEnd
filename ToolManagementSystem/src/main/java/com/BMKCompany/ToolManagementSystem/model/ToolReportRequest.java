package com.BMKCompany.ToolManagementSystem.model;

import java.util.List;

public class ToolReportRequest {
    private List<Tool> selectedTools;
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public List<Tool> getSelectedTools() {
        return selectedTools;
    }

    public void setSelectedTools(List<Tool> selectedTools) {
        this.selectedTools = selectedTools;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
