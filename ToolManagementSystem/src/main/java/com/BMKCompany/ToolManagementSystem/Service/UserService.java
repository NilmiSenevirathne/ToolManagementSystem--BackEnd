package com.BMKCompany.ToolManagementSystem.Service;

<<<<<<< Updated upstream
import com.BMKCompany.ToolManagementSystem.Exception.UserNotFoundException;
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
=======
import com.BMKCompany.ToolManagementSystem.model.User;
import com.BMKCompany.ToolManagementSystem.repository.UserRepository;
>>>>>>> Stashed changes
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
<<<<<<< Updated upstream

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

=======
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void CreateNewUser(User user) throws Exception {
        User checkUser = userRepository.findByUsername(user.getUsername());
        if(checkUser != null){
            throw new Exception("User Already Exist");
        }
        user.setPassword(User.encrypt(user.getPassword()));
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void updateUser(User user) {
        User currentUser = userRepository.findById(user.getUserid()).get();

        currentUser.setUsername(user.getUsername());
        currentUser.setFirstname(user.getFirstname());
        currentUser.setLastname(user.getLastname());
        currentUser.setNic(user.getNic());
        currentUser.setContact(user.getContact());
        currentUser.setRole(user.getRole());
        currentUser.setImageurl(user.getImageurl());

        userRepository.save(currentUser);
    }

    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
}
>>>>>>> Stashed changes
