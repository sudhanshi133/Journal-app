package com.example.project.Service;

import com.example.project.pojo.UserPojo;
import com.example.project.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserPojo> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserPojo> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void saveUser(UserPojo user) {
        userRepository.save(user);
    }
    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public UserPojo findByUsername(String username){
    	return userRepository.findByUsername(username);
    }
}
