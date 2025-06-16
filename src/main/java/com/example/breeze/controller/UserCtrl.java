package com.example.breeze.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.breeze.security.CustomUserDetails;
import com.example.breeze.service.UserService;


import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserCtrl {
    private final UserService userService;
    private final WhisperRepository whisperService;

    public UserCtrl(UserService userService, WhisperRepository whisperService) {
        this.userService = userService;
        this.whisperService = whisperService;
    }

    @GetMapping("/check-delete")
    public String userDeleteForm() {
        return "/check-delete";
    }

    @PostMapping("/check-delete")
    public String postMethodName() {
        // get current user id
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long userId = ((CustomUserDetails) principal).getUserId();
        whisperService.deleteWhisperByUserId(userId);
        // whisperService.removeUserId(userId);
        userService.deleteUserById(userId);
        
        return "redirect:/logout";
    }

}
