package com.example.music_management.form;
 import lombok.Data;
 import java.time.LocalTime;
 @Data
 public class MusicForm {
    private String title;
    private LocalTime duration;
    private long albumId;
 }