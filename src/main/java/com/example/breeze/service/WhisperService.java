package com.example.breeze.service;

import com.example.breeze.entity.whisper;
import com.example.breeze.form.whisperForm;
import com.example.breeze.repository.WhisperRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WhisperService {
  private final WhisperRepository whisperRepository;
  public WhisperService(WhisperRepository whisperRepository) {
    this.whisperRepository = whisperRepository;
  }

  public List<whisper> getAllwhispers(long albumId) {
    return whisperRepository.selectAllWhispers(albumId);
  }

  public void insertwhisper(whisperForm whisperForm) {
    whisper whisper = new whisper();
    whisper.setText(whisperForm.getText());
    whisper.setAnonymous(whisperForm.getAnonymous());
    whisperRepository.insertwhisper(whisper);
  }

  public whisper getwhisperById(long whisperId) {
    return whisperRepository.selectwhisperById(whisperId);
  }
}