package com.bringg.demo.dna.controllers.advices;

import com.bringg.demo.dna.genefinder.exceptions.GeneNotFoundException;
import com.bringg.demo.dna.genefinder.exceptions.GeneNotSupportedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenesControllerAdvice
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ GeneNotFoundException.class })
    public ResponseEntity<Object> handleGeneNotFoundException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ GeneNotSupportedException.class })
    public ResponseEntity<Object> handleGeneNotSupportedException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}