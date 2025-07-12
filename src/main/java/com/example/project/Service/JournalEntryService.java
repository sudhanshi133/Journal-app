package com.example.project.Service;

import com.example.project.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
}
