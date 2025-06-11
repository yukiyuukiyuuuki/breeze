package com.example.breeze.repository;

import com.example.breeze.entity.Whisper;
import com.example.breeze.mapper.WhisperMapper; // mapperが入力された後に確認
import com.example.breeze.viewmodel.WhisperViewModel;

import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class WhisperRepository {
  private final WhisperMapper whisperMapper;
  public WhisperRepository(WhisperMapper whisperMapper) {
    this.whisperMapper = whisperMapper;
  }
  /*
  public List<Music> getMusicsByAlbumId(long albumId) {
    return musicMapper.selectMusicsById(albumId);
  }
    */
  public List<WhisperViewModel> selectAllWhispers() { // 引数などのチェック必要
    return whisperMapper.selectAllWhispers(); // sellect -> select で動作するように揃えた。
  }

  public WhisperViewModel selectWhisperById(long whisperId) {
    return whisperMapper.selectWhisperById(whisperId);
  }
  public void insertWhisper(Whisper whisper) {
    whisperMapper.insertWhisper(whisper);
  }

  /*　追加要件用
  public void deleteMusicById(long musicId) {
    musicMapper.deleteMusicById(musicId);
  }

  public void updateMusic(Music music) {
    musicMapper.updateMusic(music);
  }

  public Music selectMusicById(long musicId) {
    return musicMapper.selectMusicById(musicId);
  }
  */

}