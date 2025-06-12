package com.example.breeze.dataformat.viewmodel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Data
public class WhisperViewModel {
    private long userId;
    private long WhisperId;
    private String userName;
    private String text;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime postDate;
    private boolean anonymous;
}
