package com.example.albumes.service;

import com.example.albumes.exceptions.ArtistNotFound;
import com.example.albumes.models.Artist;
import com.example.albumes.repository.ArtistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final KafkaProducerService kafkaProducerService;

    @Override
    public Artist getArtist(String id) {
        String messageError = String.format("The artist with the id: %s was not found", id);
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> {
                    kafkaProducerService.send(String.format("The artist with the id: %s was not found", id));
                    return new ArtistNotFound(messageError);
                });
        kafkaProducerService.send(String.format("The artist with the id: %s was get", artist.getId()));
        return artist;
    }

    @Override
    public String saveArtist(Artist artist) {
        artist.setId(UUID.randomUUID().toString());
        artistRepository.save(artist);
        return artistRepository.save(artist).getId();
    }
}
