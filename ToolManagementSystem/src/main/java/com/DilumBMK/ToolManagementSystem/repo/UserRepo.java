package com.DilumBMK.ToolManagementSystem.repo;

import com.DilumBMK.ToolManagementSystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository< Users , String> {


}
