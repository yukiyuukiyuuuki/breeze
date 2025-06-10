package com.example.breeze.service;

import com.example.breeze.entity.Whisper;
import com.example.breeze.entity.User;
import com.example.breeze.form.UserForm;
import com.example.breeze.repository.UserRepository;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository UserRepository;

  public UserService(UserRepository UserRepository) {
    this.UserRepository = UserRepository;
  }

  public void createdUser(UserForm UserForm) {
    User User = new User();
    User.setName(UserForm.getName());
    User.setPassword(UserForm.getPassword());
    UserRepository.insertUser(User);
  }

  public User getUserById(long UserId){
    return UserRepository.selectUserById(UserId);
  }

  public void deleteUserById(long UserId) {
    UserRepository.deleteUserById(UserId);
  }
}
