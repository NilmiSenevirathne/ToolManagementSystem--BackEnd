package com.BMKCompany.ToolManagementSystem.repository;

import com.BMKCompany.ToolManagementSystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< Updated upstream
public interface UserRepository extends JpaRepository<User,String>{
=======
public interface UserRepository extends JpaRepository<User,Integer>{

    User findByUsername(String username);
>>>>>>> Stashed changes

}
