package com.example.project.Service;

import com.example.project.pojo.UserPojo;
import com.example.project.pojo.JournalPojo;
import com.example.project.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;

    public void saveJournalEntry(JournalPojo pojo, String username){
        UserPojo user = userService.findByUsername(username);
        JournalPojo saved=journalEntryRepository.save(pojo);
        user.getJournals().add(saved);
        // here i was just checking through this if transaction is working or not
       // user.setUserName(null);
        userService.saveUser(user);
    }

    public List<JournalPojo> getAllEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<JournalPojo> getById(JournalPojo pojo){
        ObjectId id = pojo.getId();
        return journalEntryRepository.findById(id);
    }

    public void deleteById(JournalPojo pojo,String username){
        UserPojo user = userService.findByUsername(username);
        user.getJournals().removeIf(p -> p.getId()==pojo.getId());
        userService.saveUser(user);
        ObjectId id = pojo.getId();
        journalEntryRepository.deleteById(id);

    }

    public void updateJournalEntry(JournalPojo journalPojo) {
       Optional<JournalPojo> pojo= journalEntryRepository.findById(journalPojo.getId());
        JournalPojo existingPojo = pojo.get();
        if(journalPojo.getTitle()!=null && !journalPojo.getTitle().isEmpty()) existingPojo.setTitle(journalPojo.getTitle());
        if(journalPojo.getContent()!=null && !journalPojo.getContent().isEmpty()) existingPojo.setContent(journalPojo.getContent());
        journalEntryRepository.save(existingPojo);
    }
}
