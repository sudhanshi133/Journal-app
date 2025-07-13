package com.example.project.pojo;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class AbstractPojo {
    private LocalDateTime date=LocalDateTime.now();
}
