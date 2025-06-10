package com.example.breeze.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.breeze.entity.Album;
import com.example.breeze.entity.Music;
import com.example.breeze.form.AlbumForm;
import com.example.breeze.form.MusicForm;
import com.example.breeze.service.AlbumService;
import com.example.breeze.service.MusicService;
import com.example.breeze.viewmodel.AlbumViewModel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/breeze")
public class Ctrl {
  private final WhisperService whisperService;
  private final MusicService musicService;

  public Ctrl(WhisperService whisperService, MusicService musicService) {
    this.whisperService = whisperService;
    this.musicService = musicService;
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping
  public String timeLine(Model model) {
    // List<Album> albums = albumService.getAllAlbums();

    List<Whisper> whispers = WhisperService.getAllWhispers();
    model.addAttribute("whispers", whispers);
    return "breeze/timeline";
  }

  @GetMapping("/whisper")
  public String whisperForm(Model model) {
    WhisperForm whisperForm = new WhisperForm();
    model.addAttribute("whisperForm", whisperForm);
    return "breeze/whisper";
  }

  @PostMapping("/whisper")
  public String whisper(WhisperForm whisperForm // , Model model
  ) {
    whisperService.insertWhisper(whisperForm);

    // List<Album> albums = albumService.getAllAlbums();
    // model.addAttribute("albums", albums);
    // return "album/album-list";

    return "redirect:/timeLine";
  }

  @GetMapping("/{whisperId}")
  public String album(@PathVariable long whisperId, Model model) {
    Whisper whisper = whisperService.getLongWhisperById(whisperId);
    model.addAttribute("whisper", whisper);
    return "whisper/whisper-detail";
  }
}
