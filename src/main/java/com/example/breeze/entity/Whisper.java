package com.example.breeze.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class Whisper {
    private long userId;
    private long WhisperId;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime postDate;
    private boolean anonymous;
}
