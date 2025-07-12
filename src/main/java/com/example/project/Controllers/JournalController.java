package com.example.project.Controllers;

import com.example.project.Service.JournalEntryService;
import com.example.project.pojo.journalPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void saveEntry(@RequestBody journalPojo journalPojo){
        journalEntryService.saveEntry(journalPojo);
    }

    @GetMapping("id/{myId}")
    public List<journalPojo> get(@PathVariable Long myId){
        return null;
    }
}
