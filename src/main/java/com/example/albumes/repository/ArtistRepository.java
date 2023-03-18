package com.example.albumes.repository;

import com.example.albumes.models.Artist;
import org.springframework.data.repository.CrudRepository;


public interface ArtistRepository extends CrudRepository<Artist, String> {

}
