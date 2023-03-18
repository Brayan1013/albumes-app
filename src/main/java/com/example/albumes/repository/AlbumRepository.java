package com.example.albumes.repository;

import com.example.albumes.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AlbumRepository extends CrudRepository<Album, String> {
}
