package com.example.albumes.exceptions;

public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException(String message) {
        super(message);
    }
}

