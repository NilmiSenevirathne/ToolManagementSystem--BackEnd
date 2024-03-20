package com.DilumBMK.ToolManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Component
@Entity
@Table(name = "Users")
public class Users  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String user_Id;

    @Column(name = "username",nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "firstname" ,nullable = false)
    private String fName;

    @Column(name = "lastname" ,nullable = false)
    private String lName;

    @Column(nullable = false)
    private int nic;

    @ManyToOne
    @JoinColumn(name = "userTypeID")
    private UserType userTypeID;

    private int contact;

    private  byte[] pic;





}
