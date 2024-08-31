package com.BMKCompany.ToolManagementSystem.model;
/* Created by Group02 */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    private String userid;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String nic;
    private Long contact;


    @Enumerated(EnumType.STRING)
    private Role role;


//    @Lob
//    @Column(columnDefinition = "LONGBLOB")
//    private byte[] userimageData;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

//
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public byte[] getImageData() {
//        return userimageData;
//    }
//
//    public void setImageData(byte[] imageData) {
//        this.userimageData = userimageData;
//    }

}
