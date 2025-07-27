package com.example.project.Controllers;

import com.example.project.Service.JournalEntryService;
import com.example.project.Service.UserService;
import com.example.project.pojo.JournalPojo;
import com.example.project.pojo.UserPojo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserPojo pojo = userService.findByUsername(username);
        return pojo.getJournals();
    }

    @PostMapping
    public ResponseEntity<?> saveEntry(@RequestBody JournalPojo journalPojo) {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        journalEntryService.saveJournalEntry(journalPojo,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<?> updateEntry(@RequestBody JournalPojo journalPojo){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserPojo user = userService.findByUsername(username);
        List<JournalPojo> pojos = user.getJournals().stream().filter(x->x.getId().equals(journalPojo.getId())).toList();
        if(pojos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        journalEntryService.updateJournalEntry(journalPojo);
        return new ResponseEntity<>(journalPojo,HttpStatus.OK);
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntry(@PathVariable ObjectId id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserPojo user = userService.findByUsername(username);
        List<JournalPojo> pojos = user.getJournals().stream().filter(x->x.getId().equals(id)).toList();
        if(pojos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        journalEntryService.deleteById(id,username);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByid(@PathVariable ObjectId id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        String username=authentication.getName();
        UserPojo user = userService.findByUsername(username);
        List<JournalPojo> pojos = user.getJournals().stream().filter(x->x.getId().equals(id)).toList();
        if(pojos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<JournalPojo> optional=journalEntryService.getById(id);
            if(optional.isPresent()){
                return new ResponseEntity<>(optional.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>("No such entry",HttpStatus.NOT_FOUND);
            }
    }
}
