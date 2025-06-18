package com.example.breeze.service;

import com.example.breeze.dataformat.entity.User;
import com.example.breeze.dataformat.form.UserForm;
import com.example.breeze.db.repository.UserRepository;
import com.example.breeze.security.CustomUserDetails;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository UserRepository;
  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository UserRepository, PasswordEncoder passwordEncoder) {
    this.UserRepository = UserRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void createdUser(UserForm UserForm) {
    User user = new User();
    user.setName(UserForm.getName());
    String hashedPassword = passwordEncoder.encode(UserForm.getPassword());
    user.setPassword(hashedPassword);
    UserRepository.insertUser(user);
  }

  public User getUserById(long UserId) {
    return UserRepository.selectUserById(UserId);
  }

  public void deleteUserById(long UserId) {
    UserRepository.deleteUserById(UserId);
  }

  public boolean checkUserAlreadyExist(String name) {
    return UserRepository.checkUserAlreadyExist(name);
  }

  public long getCurrentUserId() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    long userId = -1;
    if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
      CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
      userId = customUserDetails.getUserId();
    }
    return userId;
  }
}
