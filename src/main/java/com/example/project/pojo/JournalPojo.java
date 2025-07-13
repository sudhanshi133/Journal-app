package com.example.project.pojo;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "journal_entries")
public class JournalPojo extends AbstractPojo{
    @Id
    private ObjectId id;
    private String title;
    private String content;


    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
