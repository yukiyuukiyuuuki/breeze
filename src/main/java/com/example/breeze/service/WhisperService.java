package com.example.breeze.service;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.form.WhisperForm;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;
import com.example.breeze.db.repository.WhisperRepository;

import org.springframework.stereotype.Service;

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
    return whisperRepository.selectWhisperById(whisperId);
  }

  public void updateWhisper(WhisperForm whisperForm, long whisperId) {
    Whisper whisper = new Whisper();
    whisper.setText(whisperForm.getText());
    whisper.setAnonymous(whisperForm.getAnonymous());
    whisper.setWhisperId(whisperId);
    whisperRepository.updateWhisper(whisper);
  }
}