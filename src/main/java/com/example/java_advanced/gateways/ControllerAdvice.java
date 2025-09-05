package com.example.java_advanced.gateways;

import com.example.java_advanced.gateways.dtos.response.AlunoResponseDto;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {


//    @ExceptionHandler(DuplicateKeyException.class)
//    public ResponseEntity<?> handleDuplicateKeyException(DuplicateKeyException ex) {
//        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(ex.getMessage());
//    }
//
//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> handleException(RuntimeException ex) {
//        return ResponseEntity.badRequest().body(ex.getMessage());
//    }

}
