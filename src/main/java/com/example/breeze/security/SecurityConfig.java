package com.example.breeze.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(request -> request
            .requestMatchers("/", "/login", "/time-line").permitAll() // ここで許可するパスを指定
            .anyRequest().authenticated())
        .formLogin(login -> login
            .loginProcessingUrl("/login")
            .loginPage("/login")
            .defaultSuccessUrl("/time-line") // ログインに成功したらtime-lineに戻す
            .failureUrl("/login?error")
            .permitAll());
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
