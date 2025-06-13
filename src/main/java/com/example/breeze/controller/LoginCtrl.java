package com.example.breeze.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCtrl {
  @GetMapping("/login")
  public String login() {
    return "login";
  }
  @GetMapping("/check-logout")
  public String getcheck() {
    return "check-logout";
  }
}
