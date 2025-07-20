package com.example.project.Controllers;

import com.example.project.Service.UserService;
import com.example.project.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/public")
@RestController
public class PublicController {
@Autowired
private UserService userService;
    @PostMapping("/create-user")
    public ResponseEntity<?> saveUsers(@RequestBody UserPojo user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception ex){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
