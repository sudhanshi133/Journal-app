package com.example.project.Controllers;

import com.example.project.Service.UserService;
import com.example.project.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserPojo> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public void createUser(UserPojo user) {
        userService.saveUser(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(UserPojo user, @PathVariable String username) {
        userService.updateUser(username, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
