package com.example.breeze.db.mapper;

import com.example.breeze.dataformat.entity.Whisper;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface WhisperMapper {

  @Select("""
      SELECT users.user_id, whisper.whisper_id, users.name, whisper.text, whisper.post_date, whisper.anonymous
      FROM whisper
      JOIN users ON whisper.user_id = users.user_id
      ORDER BY post_date DESC
      """)
  public List<WhisperViewModel> selectAllWhispers();

  @Select("""
      SELECT users.user_id, whisper.whisper_id, users.name, whisper.text, whisper.post_date, whisper.anonymous
      FROM whisper
      JOIN users ON whisper.user_id = users.user_id
      where whisper.whisper_id = #{whisperId}
      """)
  public WhisperViewModel selectWhisperById(long whisperId);

  @Insert("INSERT INTO whisper (user_id, text, anonymous) VALUES (#{userId}, #{text}, #{anonymous})")
  @Options(useGeneratedKeys = true, keyProperty = "whisperId")
  void insertWhisper(Whisper whisper);

  @Delete("DELETE FROM whisper WHERE user_id = #{userId}")
  void deleteWhisperByUserId(long userId);

  @Update("UPDATE whisper SET user_id = NULL where user_id = #{userId}")
  void removeUserId(long userId);

  @Update("UPDATE whisper SET text = #{text} , anonymous = #{anonymous} where whisper_id = #{whisperId}")
  void updateWhisper(Whisper whisper);

  @Delete("DELETE FROM whisper WHERE whisper_id = #{whisperId}")
  void deleteWhisper(long whisperId);
}