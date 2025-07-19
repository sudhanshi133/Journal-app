package com.example.project.Controllers;

import com.example.project.Service.UserService;
import com.example.project.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/public")
@RestController
public class PublicController {
@Autowired
private UserService userService;
    @GetMapping("/create-user")
    public List<UserPojo> getAllUsers() {
        return userService.getAllUsers();
    }
}
