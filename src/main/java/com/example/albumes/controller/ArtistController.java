package com.example.albumes.controller;

import com.example.albumes.models.Artist;
import com.example.albumes.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/artist/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable String id){
        Artist artist = artistService.getArtist(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(artist);
    }

    @PostMapping("/artist")
    public ResponseEntity<?> saveBeneficiary(@RequestBody Artist artist){
        String uuid = artistService.saveArtist(artist);
        return ResponseEntity.status(HttpStatus.CREATED).body(uuid);
    }
}
