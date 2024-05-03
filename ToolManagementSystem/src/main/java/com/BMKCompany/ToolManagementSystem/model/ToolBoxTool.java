package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ToolBoxTool")
public class ToolBoxTool {

  @Id
    private String ToolBoxId;

    private String site_supervisor_id;

    private String project_id;

    private String Tools;


    public String getToolBoxId() {
        return ToolBoxId;
    }

    public void setToolBoxId(String toolBoxId) {
        ToolBoxId = toolBoxId;
    }

    public String getSite_supervisor_id() {
        return site_supervisor_id;
    }

    public void setSite_supervisor_id(String site_supervisor_id) {
        this.site_supervisor_id = site_supervisor_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getTools() {
        return Tools;
    }

    public void setTools(String tools) {
        Tools = tools;
    }
}
