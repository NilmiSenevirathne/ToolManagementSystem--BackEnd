package com.BMKCompany.ToolManagementSystem.repository;
import com.BMKCompany.ToolManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password );

}
