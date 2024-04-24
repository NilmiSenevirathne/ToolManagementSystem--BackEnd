package com.BMKCompany.ToolManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "ToolBox")
public class ToolBox {

    @Id
    private String toolboxId;
    private String projectId;
    private String siteSupervisorId;
    private String LocationId;

}
