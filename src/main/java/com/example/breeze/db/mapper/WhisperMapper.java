package com.example.breeze.db.mapper;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WhisperMapper {

  @Select("""
      SELECT whisper.whisper_id, user.user_id, user.name, whisper.text, whisper.post_date, whisper.anonymous
      FROM whisper
      JOIN user ON whisper.user_id = user.user_id
      """)
  public List<WhisperViewModel> selectAllWhispers();

  @Select("""
      SELECT whisper.whisper_id, user.user_id, user.name, whisper.text, whisper.post_date, whisper.anonymous
      FROM whisper
      JOIN user ON whisper.user_id = user.user_id
      where whisper.whisper_id = #{whisperId}
      """)
  public WhisperViewModel selectWhisperById(long whisperId);

  @Insert("INSERT INTO whisper (user_id, text, post_date, anonymous) VALUES (#{user_id}, #{text}, #{post_date}, #{anonymous})")
  @Options(useGeneratedKeys = true, keyProperty = "whisper_id")
  void insertWhisper(Whisper whisper);

}