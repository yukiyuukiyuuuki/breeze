package com.example.breeze.service;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.form.WhisperForm;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;
import com.example.breeze.db.repository.WhisperRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

@Service
public class WhisperService {
  private final WhisperRepository whisperRepository;

  public WhisperService(WhisperRepository whisperRepository) {
    this.whisperRepository = whisperRepository;
  }

  public List<WhisperViewModel> getAllwhispers() {
    List<WhisperViewModel> whispers = whisperRepository.selectAllWhispers();
    List<WhisperViewModel> buffer = new LinkedList<>();
    for (WhisperViewModel whisper : whispers) {
      String text = whisper.getText();

      if (text.length() >= 150) {
        whisper.setText(text.substring(0, 150) + "...");
      }
      whisper.setDateTimeFormat(changeDatetimeFormat(whisper));
      buffer.add(whisper);
    }
    return buffer;
  }

  public void insertwhisper(WhisperForm whisperForm, long userId) {
    Whisper whisper = new Whisper();
    whisper.setText(whisperForm.getText());
    whisper.setAnonymous(whisperForm.getAnonymous());
    whisper.setUserId(userId);
    whisperRepository.insertWhisper(whisper);
  }

  public WhisperViewModel getwhisperById(long whisperId) {
    WhisperViewModel whisper =  whisperRepository.selectWhisperById(whisperId);
    whisper.setDateTimeFormat(changeDatetimeFormat(whisper));
    return whisper;
  }

  public void updateWhisper(WhisperForm whisperForm, long whisperId) {
    Whisper whisper = new Whisper();
    whisper.setText(whisperForm.getText());
    whisper.setAnonymous(whisperForm.getAnonymous());
    whisper.setWhisperId(whisperId);
    whisperRepository.updateWhisper(whisper);
  }

  public void deleteWhisper(long whisperId) {
    whisperRepository.deleteWhisper(whisperId);
  }

  public static String changeDatetimeFormat(WhisperViewModel whisper) {
    LocalDateTime now = LocalDateTime.now();
    LocalDateTime postDate = whisper.getPostDate();

    long yearsDiff = ChronoUnit.YEARS.between(postDate, now);
    long daysDiff = ChronoUnit.DAYS.between(postDate, now);

    String formattedDate;
    if (yearsDiff == 0 && daysDiff == 0) {
      formattedDate = postDate.format(DateTimeFormatter.ofPattern("HH:mm"));
    } else if (yearsDiff == 0) {
      formattedDate = postDate.format(DateTimeFormatter.ofPattern("MM-dd HH:mm"));
    } else {
      formattedDate = postDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    return formattedDate;
  }
}