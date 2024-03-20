package com.DilumBMK.ToolManagementSystem.repo;

import com.DilumBMK.ToolManagementSystem.Entity.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepo extends JpaRepository <Messages,String>{
}
