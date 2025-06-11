package com.example.breeze.security;

import com.example.breeze.dataformat.entity.User;
import com.example.breeze.db.repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.selectUserByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("user not found");
    }
    return new CustomUserDetails(user);
  }
}