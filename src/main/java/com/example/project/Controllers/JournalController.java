package com.example.project.Controllers;

import com.example.project.pojo.journalPojo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalController {

    @GetMapping
    public List<journalPojo> get(){
        return null;
    }

    @GetMapping("id/{myId}")
    public List<journalPojo> get(@PathVariable Long myId){
        return null;
    }
}
