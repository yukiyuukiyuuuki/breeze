package com.example.breeze.repository;

import com.example.breeze.entity.User;
import com.example.breeze.mapper.UserMapper;
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
}