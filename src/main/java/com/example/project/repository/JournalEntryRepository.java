package com.example.project.repository;

import com.example.project.pojo.JournalPojo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface JournalEntryRepository extends MongoRepository<JournalPojo, ObjectId>{

}
