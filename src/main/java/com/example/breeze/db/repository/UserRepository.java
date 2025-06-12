package com.example.breeze.db.repository;

import com.example.breeze.dataformat.entity.User;
import com.example.breeze.db.mapper.UserMapper;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private final UserMapper userMapper;

  public UserRepository(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  public User selectUserById(long userId) {
    return userMapper.selectUserById(userId);
  }

  public void insertUser(User user) {
    userMapper.insertUser(user);
  }

  public void deleteUserById(long userId) {
    userMapper.deleteUser(userId);
  }

  public User selectUserByUsername(String username) {
    return userMapper.selectUserByUsername(username);
  }
}