package com.example.albumes.service;

import com.example.albumes.models.Artist;

import java.util.UUID;

public interface ArtistService {

    Artist getArtist(String id);
    String saveArtist(Artist artist);
}
