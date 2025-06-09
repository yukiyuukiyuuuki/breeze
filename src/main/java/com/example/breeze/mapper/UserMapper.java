package com.example.music_management.mapper;

import com.example.music_management.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT user_id, username, password, created_at FROM users WHERE username = #{username}")
  User selectUserByUsername(String username);
}