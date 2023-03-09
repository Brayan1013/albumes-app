package com.example.albumes.service;

import com.example.albumes.exceptions.AlbumNotFoundException;
import com.example.albumes.models.Album;
import com.example.albumes.repository.AlbumRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Log4j2
public class AlbumServiceImpl implements AlbumService{

    private final AlbumRepository albumRepository;

    @Override
    public Album getAlbum(UUID id) {
        return albumRepository.findById(id).orElseThrow(() ->
                new AlbumNotFoundException(String.format("The album with de id: %s was not found", id)));
    }

    @Override
    public UUID saveAlbum(Album album) {
        Album save = albumRepository.save(album);
        return save.getId();
    }
}
