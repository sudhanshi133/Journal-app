package com.example.project.Service;

import com.example.project.pojo.UserPojo;
import com.example.project.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Component
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private static final PasswordEncoder encoder=new BCryptPasswordEncoder();

    public List<UserPojo> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserPojo> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void saveUser(UserPojo user) {
        if(userRepository.findByUserName(user.getUserName())==null){
            throw new RuntimeException("User already exist");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }
    public void deleteUser(ObjectId id) {
        userRepository.deleteById(id);
    }

    public void updateUser(String username,UserPojo newUser){
        UserPojo user = userRepository.findByUserName(username);
            user.setUserName(newUser.getUserName());
            user.setPassword(newUser.getPassword());
           userRepository.save(user);
    }

    public UserPojo findByUsername(String username){
    	return userRepository.findByUserName(username);
    }
}
