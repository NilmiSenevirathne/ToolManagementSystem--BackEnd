package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.Exception.UserNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository UserRepository;

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public User getUserById(String userid) {
        return UserRepository.findById(userid)
                .orElseThrow(() -> new UserNotFoundException(userid));
    }

    public User createUser(User user) {
        return UserRepository.save(user);
    }

    public User updateUser(String userid, User updatedUser) {
        User existingUser = getUserById(userid);

        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setFirstname(updatedUser.getFirstname());
        existingUser.setLastname(updatedUser.getLastname());
        existingUser.setNic(updatedUser.getNic());
        existingUser.setContact(updatedUser.getContact());
        existingUser.setRole(updatedUser.getRole());

        return UserRepository.save(existingUser);
    }

    public void deleteUser(String userid) {
        if (!UserRepository.existsById(userid)) {
            throw new UserNotFoundException(userid);
        }
        UserRepository.deleteById(userid);
    }
}

