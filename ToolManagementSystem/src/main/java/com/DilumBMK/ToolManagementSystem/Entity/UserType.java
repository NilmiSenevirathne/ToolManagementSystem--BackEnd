package com.DilumBMK.ToolManagementSystem.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Component
@Entity
@Table(name = "UserType")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTypeID;

    @Column(name = "userType")
    private String userType;

    @OneToMany(mappedBy = "userTypeID")
    private List<Users>users;

}
