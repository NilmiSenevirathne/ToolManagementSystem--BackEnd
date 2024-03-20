package com.DilumBMK.ToolManagementSystem.service;

import com.DilumBMK.ToolManagementSystem.repo.UsersTypeRepo;
import org.springframework.stereotype.Service;

@Service
public class UserTypeService {

    private final UsersTypeRepo usersTypeRepo;

    public UserTypeService(UsersTypeRepo usersTypeRepo) {
        this.usersTypeRepo = usersTypeRepo;
    }
}
