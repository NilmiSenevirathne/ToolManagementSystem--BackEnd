package com.BMKCompany.ToolManagementSystem.model;

import java.util.List;

public class ToolReportRequest {
    private List<Tools> selectedTools;
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public List<Tools> getSelectedTools() {
        return selectedTools;
    }

    public void setSelectedTools(List<Tools> selectedTools) {
        this.selectedTools = selectedTools;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
