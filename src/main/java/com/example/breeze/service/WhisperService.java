package com.example.breeze.service;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.form.WhisperForm;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;
import com.example.breeze.db.repository.WhisperRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WhisperService {
  private final WhisperRepository whisperRepository;
  public WhisperService(WhisperRepository whisperRepository) {
    this.whisperRepository = whisperRepository;
  }

  public List<WhisperViewModel> getAllwhispers() {
    return whisperRepository.selectAllWhispers();
  }

  public void insertwhisper(WhisperForm whisperForm) {
    Whisper whisper = new Whisper();
    whisper.setText(whisperForm.getText());
    whisper.setAnonymous(whisperForm.getAnonymous());
    whisperRepository.insertWhisper(whisper);
  }

  public WhisperViewModel getwhisperById(long whisperId) {
    return whisperRepository.selectWhisperById(whisperId);
  }
}