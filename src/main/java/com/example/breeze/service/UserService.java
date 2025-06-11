package com.example.breeze.service;

import com.example.breeze.dataformat.entity.User;
import com.example.breeze.dataformat.form.UserForm;
import com.example.breeze.db.repository.UserRepository;

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
