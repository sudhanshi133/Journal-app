package com.example.project.Controllers;

import com.example.project.Service.JournalEntryService;
import com.example.project.pojo.journalPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<journalPojo> get(){
        return journalEntryService.getAllEntries();
    }

    @PostMapping
    public ResponseEntity<?> saveEntry(@RequestBody journalPojo journalPojo){
        Optional<journalPojo> journalPojo1 = journalEntryService.getById(journalPojo);
        if (!journalPojo1.isPresent()) {
            journalEntryService.saveEntry(journalPojo);
            return new ResponseEntity<>(journalPojo, HttpStatus.OK);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    @GetMapping("id/{myId}")
    public List<journalPojo> get(@PathVariable Long myId){
        return null;
    }
}
