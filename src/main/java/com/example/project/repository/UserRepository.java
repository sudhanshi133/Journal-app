package com.example.project.repository;

import com.example.project.pojo.UserPojo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserPojo, ObjectId> {
    UserPojo findByUserName(String username);
}
