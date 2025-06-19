package com.example.breeze.controller;

import com.example.breeze.dataformat.form.UserForm;
import com.example.breeze.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(UserForm userform) {
        String name = userform.getName().trim();
        String pass = userform.getPassword()
                .trim()
                .replace(" ", "");
        if (name.isEmpty() || pass.isEmpty() || name.length() > 20 || pass.length() <= 8 || pass.length() > 50) {
            return "redirect:/register?invalid";
        } else if (userService.checkUserAlreadyExist(name)) {
            return "redirect:/register?exist";
        }
        userService.createdUser(userform);
        return "redirect:/login?register";
    }
}
