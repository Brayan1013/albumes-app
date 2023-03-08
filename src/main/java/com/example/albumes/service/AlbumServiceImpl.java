package com.example.albumes.service;

import com.example.albumes.models.Album;
import com.example.albumes.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.UUID.randomUUID;

@Service
@AllArgsConstructor
public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;

    @Override
    public Album getAlbum(UUID id) {
        return albumRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Album not found"));
    }

    @Override
    public UUID saveAlbum(Album album) {
        Album save = albumRepository.save(album);
        return save.getId();
    }
}
