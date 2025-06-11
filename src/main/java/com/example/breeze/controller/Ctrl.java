package com.example.breeze.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.breeze.dataformat.entity.Whisper;
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
    // List<Album> albums = albumService.getAllAlbums();

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
  public String whisper(WhisperForm whisperForm // , Model model
  ) {
    whisperService.insertwhisper(whisperForm);

    // List<Album> albums = albumService.getAllAlbums();
    // model.addAttribute("albums", albums);
    // return "album/album-list";

    return "redirect:/breeze/time-line";
  }

  @GetMapping("/{whisperId}")
  public String longview(@PathVariable long whisperId, Model model) {
    WhisperViewModel whisper = whisperService.getwhisperById(whisperId);
    model.addAttribute("whisper", whisper);
    return "breeze/preview-long";
  }
}
