package com.example.project.Controllers;

import com.example.project.Service.UserService;
import com.example.project.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/get-users")
    public ResponseEntity<?> getAllUsers(){
        List<UserPojo> users=userService.getAllUsers();
        if(users!=null){
            return new ResponseEntity<>(users,HttpStatus.OK);
        } else {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
