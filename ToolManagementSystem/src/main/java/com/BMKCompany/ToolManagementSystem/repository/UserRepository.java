package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.Role;
import com.BMKCompany.ToolManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String>{

    @Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:username)")
    Optional<User> findByUsernameIgnoreCase(@Param("username") String username);
    Optional<User> findByUsername(String username);

}
