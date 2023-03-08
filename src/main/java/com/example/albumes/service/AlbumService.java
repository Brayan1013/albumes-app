package com.example.albumes.service;

import com.example.albumes.models.Album;

import java.util.Optional;
import java.util.UUID;

public interface AlbumService {

    Album getAlbum(UUID id);
    UUID saveAlbum(Album album);
}
