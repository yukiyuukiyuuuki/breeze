package com.example.music_management.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.music_management.entity.Music;
import com.example.music_management.viewmodel.MusicViewModel;

@Mapper
public interface MusicMapper {
  @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
  List<Music> selectMusicsById(long album_id);

  @Insert("INSERT INTO musics (title, duration, album_id) VALUES (#{title}, #{duration}, #{albumId})")
  @Options(useGeneratedKeys = true, keyProperty = "musicId")
  void insertMusic(Music music);

  @Delete("DELETE FROM musics WHERE music_id = #{musicId}")
  void deleteMusicById(long musicId);

  @Update("UPDATE musics SET title = #{title}, duration = #{duration} WHERE music_id = #{musicId}")
  void updateMusic(Music music);

  @Select("SELECT * FROM musics WHERE music_id = #{musicId}")
  Music selectMusicById(long musicId);

  @Select("""
      SELECT
          musics.music_id,
          title,
          duration,
          favorites.user_id IS NOT NULL AS is_favorite
      FROM musics
      LEFT JOIN favorites ON musics.music_id = favorites.music_id AND favorites.user_id = #{userId}
      WHERE album_id = #{albumId}
      """)
  List<MusicViewModel> selectMusicsWithFavorite(long albumId, long userId);
}
