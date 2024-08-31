package com.BMKCompany.ToolManagementSystem.model;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ToolBox")
public class ToolBox {
    @Id
    private String toolbox_id;
    private String project_id;
    private String site_supervisor_id;
    private String location_id;

    @Column(name = "createdDate")  // Mapping to database column
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "toolBox", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tool> tools = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "toolbox_selected_tools", joinColumns = @JoinColumn(name = "toolbox_id"))
    @Column(name = "tool_id")
    private List<String> selectedTools = new ArrayList<>();


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
        return location_id;
    }


    public void setLocation_id(String location_id) {

        this.location_id = location_id;

    }


    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }

    public List<String> getSelectedTools() {
        return selectedTools;
    }

    public void setSelectedTools(List<String> selectedTools) {
        this.selectedTools = selectedTools;
    }
}
