package com.example.music_management.repository;

import com.example.music_management.entity.User;
import com.example.music_management.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private final UserMapper userMapper;

  public UserRepository(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public User selectUserByUsername(String username) {
    return userMapper.selectUserByUsername(username);
  }
}