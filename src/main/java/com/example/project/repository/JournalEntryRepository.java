package com.example.project.repository;

import com.example.project.pojo.journalPojo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<journalPojo, ObjectId>{

}
