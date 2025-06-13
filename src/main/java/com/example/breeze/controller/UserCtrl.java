package com.example.breeze.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.breeze.dataformat.form.UserForm;
import com.example.breeze.dataformat.form.WhisperForm;
import com.example.breeze.security.CustomUserDetails;
import com.example.breeze.service.UserService;
import com.example.breeze.service.WhisperService;

import ch.qos.logback.core.model.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
