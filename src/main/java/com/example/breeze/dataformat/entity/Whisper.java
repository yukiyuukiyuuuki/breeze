package com.example.breeze.dataformat.entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class Whisper {
    private long userId;
    private long whisperId;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime postDate;
    private boolean anonymous;
}
