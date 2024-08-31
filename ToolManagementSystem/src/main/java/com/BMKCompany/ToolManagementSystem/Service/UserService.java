package com.BMKCompany.ToolManagementSystem.Service;

import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void CreateNewUser(User user) throws Exception {
//        User checkUser = userRepository.findByUsername(user.getUsername());
//        if (checkUser != null) {
//            throw new Exception("User Already Exist");
//        }
//        System.out.println("Encrypting password for user: " + user.getUsername());
//        user.setPassword(User.encrypt(user.getPassword()));
//        System.out.println("Saving user to the repository");
//        userRepository.save(user);
//    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        User currentUser = userRepository.findById(user.getUserid()).get();

        currentUser.setUsername(user.getUsername());
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setNic(user.getNic());
        currentUser.setContact(user.getContact());
        currentUser.setRole(user.getRole());
//        currentUser.setImageurl(user.getImageurl());

        userRepository.save(currentUser);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }


    public User getUserDetailsByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
