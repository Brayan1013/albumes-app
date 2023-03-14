package com.example.albumes.service;

import com.example.albumes.models.Artist;
import com.example.albumes.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    @Override
    public Artist getArtist(UUID id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ERROR"));
    }

    @Override
    public UUID saveArtist(Artist artist) {
        return artistRepository.save(artist).getId();
    }
}
