package com.backend.zlpfinpd.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception ex) {
        log.error("Unknown exception caused: {}. \n" +
                "Stacktrace: {}", ex.getMessage(), ex.getStackTrace());
        return ResponseEntity.internalServerError().body(ex.getMessage());
    }
}
