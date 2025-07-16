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

    @GetMapping("/{username}")
    public List<JournalPojo> get(@PathVariable String username) {
        UserPojo pojo = userService.findByUsername(username);
        return pojo.getJournals();
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> saveEntry(@RequestBody JournalPojo journalPojo,@PathVariable String username) {
        journalEntryService.saveJournalEntry(journalPojo,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateEntry(@RequestBody JournalPojo journalPojo){
        journalEntryService.updateJournalEntry(journalPojo);
        return new ResponseEntity<>(journalPojo,HttpStatus.OK);
}

    @DeleteMapping("/{username}")
    public void deleteEntry(@RequestBody JournalPojo journalPojo,@PathVariable String username){
        journalEntryService.deleteById(journalPojo,username);
    }
}
