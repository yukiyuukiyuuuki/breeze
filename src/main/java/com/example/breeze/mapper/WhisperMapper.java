package com.example.breeze.mapper;

import com.example.breeze.entity.Whisper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WhisperMapper {

  @Select("""
      SELECT whisper.whisper_id, user.user_id, whisper.text, whisper.post_date, whisper.anonymous
      FROM whisper
      JOIN user ON whisper.user_id = user.user_id
      """)
  public List<Whisper> selectAllWhisper();

  @Insert("INSERT INTO whisper (user_id, text, post_date, anonymous) VALUES (#{user_id}, #{text}, #{post_date}, #{anonymous})")
  @Options(useGeneratedKeys = true, keyProperty = "whisper_id")
  void insertWhisper(Whisper whisper);

}