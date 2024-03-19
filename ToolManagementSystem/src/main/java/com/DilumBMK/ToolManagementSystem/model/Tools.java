package com.DilumBMK.ToolManagementSystem.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "Tools")
public class Tools {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tool_Id")
    private Long tool_Id;

    @Column(name = "tool_Name")
    private String tool_Name;

    @Column(name = "savedQuantity")
    private int  savedQuantity;

    @Column(name = "allocatedQuantity")
    private int  allocatedQuantity;

    @Column(name = "Pic")
    private byte[] Pic;

    public Long getTool_Id() {
        return tool_Id;
    }

    public void setTool_Id(Long tool_Id) {
        this.tool_Id = tool_Id;
    }

    public String getTool_Name() {
        return tool_Name;
    }

    public void setTool_Name(String tool_Name) {
        this.tool_Name = tool_Name;
    }

    public int getSavedQuantity() {
        return savedQuantity;
    }

    public void setSavedQuantity(int savedQuantity) {
        this.savedQuantity = savedQuantity;
    }

    public int getAllocatedQuantity() {
        return allocatedQuantity;
    }

    public void setAllocatedQuantity(int allocatedQuantity) {
        this.allocatedQuantity = allocatedQuantity;
    }

    public byte[] getPic() {
        return Pic;
    }

    public void setPic(byte[] pic) {
        Pic = pic;
    }
}
