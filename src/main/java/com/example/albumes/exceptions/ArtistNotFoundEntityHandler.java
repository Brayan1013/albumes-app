package com.example.albumes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ArtistNotFoundEntityHandler {

    @ExceptionHandler(ArtistNotFound.class)
    public ResponseEntity<ExceptionModel> artistNot(RuntimeException ex, WebRequest request){
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exceptionModel);
    }
}
