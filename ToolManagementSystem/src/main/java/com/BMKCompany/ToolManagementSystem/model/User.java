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
    @GeneratedValue
    private Integer userid;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String nic;
    private Long contact;
    private String imageurl;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static String encrypt(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public static boolean verify(String input, String originalHash) {
        String inputHash = encrypt(input);
        return inputHash.equals(originalHash);
    }

}
