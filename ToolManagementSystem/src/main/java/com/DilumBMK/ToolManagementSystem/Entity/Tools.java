package com.DilumBMK.ToolManagementSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

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
       private String tool_Id;

       @Column(name = "tool_Name")
       private String tool_Name;

       @Column(name = "description")
       private String description;

       @Column(name = "savedQuantity")
       private int  savedQuantity;

       @Column(name = "allocatedQuantity")
       private int allocatedQuantity;

       @Column(name = "Pic")
       private byte[] Pic;





}
