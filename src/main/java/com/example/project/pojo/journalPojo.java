package com.example.project.pojo;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Document(collection = "journal_entries")
public class journalPojo extends AbstractPojo{
    @Id
    private ObjectId id;

    public String getContent() {
        return content;
    }

    public ObjectId getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


    private String title;
    private String content;

}
