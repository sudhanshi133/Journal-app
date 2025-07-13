package com.example.project.pojo;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@Document(collection = "journal_entries")
public class journalPojo extends AbstractPojo{
    @Id
    private ObjectId id;
    private String title;
    private String content;
}
