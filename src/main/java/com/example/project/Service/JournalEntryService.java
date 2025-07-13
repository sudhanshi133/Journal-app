package com.example.project.Service;

import com.example.project.pojo.journalPojo;
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

    public void saveEntry(journalPojo pojo){
        journalEntryRepository.save(pojo);
    }

    public List<journalPojo> getAllEntries(){
        return journalEntryRepository.findAll();
    }

    public Optional<journalPojo> getById(journalPojo pojo){
        ObjectId id = pojo.getId();
        return journalEntryRepository.findById(id);
    }
}
