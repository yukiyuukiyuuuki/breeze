package com.example.breeze.dataformat.entity;

import lombok.Data;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class User {
    private long userId;
    private String name;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime subscribeDate;
}