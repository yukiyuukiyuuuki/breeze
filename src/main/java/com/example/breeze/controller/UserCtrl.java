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

    public UserCtrl(UserService userService) {
        this.userService = userService;
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
        userService.deleteUserById(userId);

        return "redirect:/breeze";
    }

}
