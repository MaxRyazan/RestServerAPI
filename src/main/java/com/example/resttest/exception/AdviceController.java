package com.example.resttest.exception;

import com.example.resttest.exception.type.NoDataException;
import com.example.resttest.exception.type.UserNotFoundException;
import org.springdoc.api.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<?> handleNoDataException(NoDataException dataException) {
     Map<String, Object> body = new HashMap<>();
     body.put(
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss")),
        dataException.getMessage());
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(body);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception) {
        Map<String, Object> body = new HashMap<>();
        body.put(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss")), exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(body);
    }
}
