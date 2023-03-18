package com.example.albumes.controller;

import com.example.albumes.models.Album;
import com.example.albumes.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class AlbumController {

    private final AlbumService albumService;

    @PostMapping("/album")
    public ResponseEntity<?> saveAlbum(@RequestBody Album album){
        String uuid = albumService.saveAlbum(album);
        return ResponseEntity.status(HttpStatus.CREATED).body(uuid);
    }

    @GetMapping("/album/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable String id){
        Album album = albumService.getAlbum(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(album);
    }
}
