package com.example.breeze.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.breeze.dataformat.form.WhisperForm;
import com.example.breeze.dataformat.viewmodel.WhisperViewModel;
import com.example.breeze.service.UserService;
import com.example.breeze.service.WhisperService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/breeze")
public class Ctrl {
  private final WhisperService whisperService;
  private final UserService userService;

  public Ctrl(WhisperService whisperService, UserService userService) {
    this.whisperService = whisperService;
    this.userService = userService;
  }

  @GetMapping
  public String timeLine(Model model) {
    long userId = userService.getCurrentUserId();
    model.addAttribute("userId", userId);
    List<WhisperViewModel> whispers = whisperService.getAllwhispers();
    model.addAttribute("whispers", whispers);
    return "breeze/time-line";
  }

  @GetMapping("/whisper")
  public String whisperForm(Model model) {
    WhisperForm whisperForm = new WhisperForm();
    model.addAttribute("whisperForm", whisperForm);
    return "breeze/whisper-form";
  }

  @PostMapping("/whisper")
  public String whisper(WhisperForm whisperForm) {
    // get current user id
    whisperService.insertwhisper(whisperForm, userService.getCurrentUserId());
    return "redirect:/breeze";
  }

  @GetMapping("/view/{whisperId}")
  public String longview(@PathVariable long whisperId, Model model) {
    try {
      WhisperViewModel whisper = whisperService.getwhisperById(whisperId);
    } catch (NullPointerException e) {
      System.err.println("accessed none page" + e);
      return "redirect:/breeze?null";
    }
    model.addAttribute("whisper", whisper);
    return "breeze/preview-long";
  }

  @GetMapping("/edit/{whisperId}")
  public String editview(@PathVariable long whisperId, Model model) {
    WhisperViewModel whisper = whisperService.getwhisperById(whisperId);
    if (userService.getCurrentUserId() != whisper.getUserId()) {
      return "redirect:/breeze";
    }
    WhisperForm whisperForm = new WhisperForm();
    whisperForm.setText(whisper.getText());
    whisperForm.setAnonymous(whisper.isAnonymous());
    model.addAttribute("whisperId", whisper.getWhisperId());
    model.addAttribute("whisperForm", whisperForm);
    return "breeze/whisper-update";
  }

  @PostMapping("/edit/{whisperId}")
  public String edit(@PathVariable long whisperId, WhisperForm whisperForm) {
    // get current user id
    if (whisperService.getwhisperById(whisperId).getUserId() != userService.getCurrentUserId()) {
      return "redirect:/breeze";
    }
    whisperService.updateWhisper(whisperForm, whisperId);

    return "redirect:/breeze";
  }

  @PostMapping("edit/{whisperId}/delete")
  public String deleteWhisper(@PathVariable long whisperId) {
    if (whisperService.getwhisperById(whisperId).getUserId() != userService.getCurrentUserId()) {
      return "redirect:/breeze";
    }
    whisperService.deleteWhisper(whisperId);
    return "redirect:/breeze";
  }


}
