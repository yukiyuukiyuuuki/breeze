package com.example.breeze.db.repository;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;
import com.example.breeze.db.mapper.WhisperMapper;

import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class WhisperRepository {
  private final WhisperMapper whisperMapper;
  public WhisperRepository(WhisperMapper whisperMapper) {
    this.whisperMapper = whisperMapper;
  }

  public List<WhisperViewModel> selectAllWhispers() { // 引数などのチェック必要
    return whisperMapper.selectAllWhispers(); // sellect -> select で動作するように揃えた。
  }

  public WhisperViewModel selectWhisperById(long whisperId) {
    return whisperMapper.selectWhisperById(whisperId);
  }
  public void insertWhisper(Whisper whisper) {
    whisperMapper.insertWhisper(whisper);
  }

}