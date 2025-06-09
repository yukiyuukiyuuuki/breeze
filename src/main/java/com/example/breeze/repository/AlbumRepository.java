package com.example.music_management.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.music_management.entity.Album;
import com.example.music_management.mapper.AlbumMapper;
import com.example.music_management.viewmodel.AlbumViewModel;


@Repository
public class AlbumRepository {
  private final AlbumMapper albumMapper;

  public AlbumRepository(AlbumMapper albumMapper) {
    this.albumMapper = albumMapper;
  }

  public List<Album> getAllAlbums() {
    return albumMapper.selectAllAlbums();
  }

  public void insertAlbum(Album album) {
    albumMapper.insertAlbum(album);
  }

  public Album getAlbumById(long albumId){
    return albumMapper.selectAlbumById(albumId);
  }

  public void deleteAlbum(long albumId) {
    albumMapper.deleteAlbumById(albumId);
  }

  public void updateAlbum(Album album) {
    albumMapper.updateAlbum(album);
  }

  public List<AlbumViewModel> getAllAlbumsWithMusicCount() {
    return albumMapper.selectAllAlbumsWithMusicCount();
  }
}
