package com.example.music_management.AlbumController;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.music_management.entity.Album;
import com.example.music_management.entity.Music;
import com.example.music_management.form.AlbumForm;
import com.example.music_management.form.MusicForm;
import com.example.music_management.service.AlbumService;
import com.example.music_management.service.MusicService;
import com.example.music_management.viewmodel.AlbumViewModel;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {
  private final AlbumService albumService;
  private final MusicService musicService;

  public AlbumController(AlbumService albumService, MusicService musicService) {
    this.albumService = albumService;
    this.musicService = musicService;
  }

  @GetMapping
  public String albums(Model model) {
    // List<Album> albums = albumService.getAllAlbums();

    List<AlbumViewModel> albums = albumService.getAllAlbumsWithMusicCount();
    model.addAttribute("albums", albums);
    return "album/album-list";
  }

  @GetMapping("/new")
  public String albumForm(Model model) {
    AlbumForm albumForm = new AlbumForm();
    model.addAttribute("albumForm", albumForm);
    return "album/album-form";
  }

  @PostMapping("/new")
  public String createAlbum(AlbumForm albumForm // , Model model
  ) {
    albumService.createdAlbum(albumForm);

    // List<Album> albums = albumService.getAllAlbums();
    // model.addAttribute("albums", albums);
    // return "album/album-list";

    return "redirect:/albums";
  }

  @GetMapping("/{albumId}")
  public String album(@PathVariable long albumId, Model model) {
    Album album = albumService.getAlbumById(albumId);
    List<Music> musics = musicService.getMusicsByAlbumId(albumId);
    model.addAttribute("album", album);
    model.addAttribute("musics", musics);
    return "album/album-detail";
  }

  @PostMapping("/{albumId}/delete")
  public String deleteAlbum(@PathVariable long albumId) {
    albumService.deleteAlbum(albumId);
    return "redirect:/albums";
  }

  @GetMapping("/{albumId}/edit")
  public String editAlbum(@PathVariable long albumId, Model model) {
    Album album = albumService.getAlbumById(albumId);
    model.addAttribute("album", album);
    return "album/album-edit";
  }

  @PostMapping("/{albumId}/edit")
  public String updateAlbum(@PathVariable long albumId, Album album) {
    albumService.updateAlbum(albumId, album);
    return "redirect:/albums";
  }

  @GetMapping("/{albumId}/musics/new")
  public String createMusicForm(@PathVariable long albumId, Model model) {
    MusicForm musicForm = new MusicForm();
    musicForm.setAlbumId(albumId);
    model.addAttribute("musicForm", musicForm);
    return "music/music-form";
  }

  @PostMapping("/{albumId}/musics/new")
  public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
    musicService.createMusic(musicForm);
    return "redirect:/albums/" + albumId;
  }

  @PostMapping("/{albumId}/musics/{musicId}/delete")
  public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
    musicService.deleteMusic(musicId);
    return "redirect:/albums/" + albumId;
  }

  @GetMapping("/{albumId}/musics/{musicId}/edit")
  public String editMusic(@PathVariable long albumId, @PathVariable long musicId, Model model) {
    Music music = musicService.getMusicById(musicId);
    model.addAttribute("music", music);
    return "music/music-edit";
  }

  @PostMapping("/{albumId}/musics/{musicId}/edit")
  public String updateMusic(@PathVariable long albumId, @PathVariable long musicId, Music music) {
    musicService.updateMusic(musicId, music);
    return "redirect:/albums/" + albumId;
  }
}
