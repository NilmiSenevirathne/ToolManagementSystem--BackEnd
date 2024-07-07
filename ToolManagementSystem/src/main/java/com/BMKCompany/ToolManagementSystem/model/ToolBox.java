package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ToolBox")
public class ToolBox {

    @Id
    private String toolbox_id;
    private String project_id;
    private String site_supervisor_id;
    private String Location_id;
  
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public List<Tool> tools = new ArrayList<>();

    @ElementCollection
    private List <String> selectedTools;


    public String getToolbox_id() {
        return toolbox_id;
    }

    public void setToolbox_id(String toolbox_id) {
        this.toolbox_id = toolbox_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getSite_supervisor_id() {
        return site_supervisor_id;
    }

    public void setSite_supervisor_id(String site_supervisor_id) {
        this.site_supervisor_id = site_supervisor_id;
    }

    public String getLocation_id() {
        return Location_id;
    }

    public void setLocation_id(String location_id) {
        Location_id = location_id;
    }



    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;

    public List<String> getSelectedTools() {
        return selectedTools;
    }
    public void setSelectedTools(List<String> selectedTools) {
        this.selectedTools = selectedTools;

    }
}
