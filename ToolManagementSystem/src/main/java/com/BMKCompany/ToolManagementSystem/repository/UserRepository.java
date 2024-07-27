package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Role;
import com.BMKCompany.ToolManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String>{

    User findByUsername(String username);


}
