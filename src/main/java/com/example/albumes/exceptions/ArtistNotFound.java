package com.example.albumes.exceptions;

public class ArtistNotFound extends RuntimeException{

    public ArtistNotFound(String message) {
        super(message);
    }
}
