package com.example.albumes.service;

import com.example.albumes.models.Artist;

import java.util.UUID;

public interface ArtistService {

    Artist getArtist(UUID id);
    UUID saveArtist(Artist artist);
}
