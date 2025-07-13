package com.example.project.Controllers;

import com.example.project.Service.JournalEntryService;
import com.example.project.Service.UserService;
import com.example.project.pojo.JournalPojo;
import com.example.project.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalEntryService journalEntryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<JournalPojo> get() {
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public ResponseEntity<?> saveEntry(@RequestBody JournalPojo journalPojo,String username) {
        Optional<JournalPojo> journalPojo1 = journalEntryService.getById(journalPojo);
        if (!journalPojo1.isPresent()) {
            journalEntryService.saveJournalEntry(journalPojo, username);
            return new ResponseEntity<>(journalPojo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
