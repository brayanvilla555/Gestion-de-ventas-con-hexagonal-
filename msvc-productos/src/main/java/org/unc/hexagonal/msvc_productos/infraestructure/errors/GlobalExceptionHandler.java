package org.unc.hexagonal.msvc_productos.infraestructure.errors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.unc.hexagonal.msvc_productos.application.exceptions.BusinessException;
import org.unc.hexagonal.msvc_productos.application.exceptions.NotFoundException;

import java.time.Instant;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> business(BusinessException ex){
        return ResponseEntity.badRequest()
                .body(Map.of("mensaje", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    // Si dejas las validaciones en el dominio (IllegalArgumentException), conviene mapearla a 400:
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> illegalArg(IllegalArgumentException ex){
        return ResponseEntity.badRequest()
                .body(Map.of("mensaje", ex.getMessage(), "timestamp", Instant.now().toString()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validation(MethodArgumentNotValidException ex){
        var errors = ex.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        return ResponseEntity.badRequest()
                .body(Map.of("errores", errors, "timestamp", Instant.now().toString()));
    }
}