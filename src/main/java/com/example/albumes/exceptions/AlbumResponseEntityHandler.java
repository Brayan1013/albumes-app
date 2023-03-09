package com.example.albumes.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Log4j2
public class AlbumResponseEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AlbumNotFoundException.class)
    private ResponseEntity<ExceptionModel> handleAlbumNotFound(RuntimeException ex, WebRequest request){
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .message(ex.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionModel);
    }

}
