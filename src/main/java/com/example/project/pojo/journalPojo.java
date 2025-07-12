package com.example.project.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class journalPojo {
    @Id
    String id;
    String title;
    String content;
}
