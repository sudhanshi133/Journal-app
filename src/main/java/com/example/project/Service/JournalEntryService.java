package com.example.project.Service;

import com.example.project.pojo.UserPojo;
import com.example.project.pojo.JournalPojo;
import com.example.project.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveJournalEntry(JournalPojo pojo, String username){
        UserPojo user = userService.findByUsername(username);
        JournalPojo saved=journalEntryRepository.save(pojo);
        user.getJournals().add(saved);
        userService.saveUser(user);
    }

    public List<JournalPojo> getAllEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalPojo> getById(JournalPojo pojo){
        ObjectId id = pojo.getId();
        return journalEntryRepository.findById(id);
    }
}
