package com.example.breeze.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class Whisper {
    private long userId;
    private long WhisperId;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate postDate;
    private boolean anonymous;
}
