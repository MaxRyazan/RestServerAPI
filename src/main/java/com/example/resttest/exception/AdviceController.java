package com.example.resttest.exception;

import com.example.resttest.exception.type.NoDataException;
import com.example.resttest.exception.type.UserNotFoundException;
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
public class AdviceController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataException.class)
    public ResponseEntity<?> handleNoDataException() {
     Map<String, Object> body = new HashMap<>();
     body.put("time",  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss")));
     body.put("message", "DATA NOT FOUND");
     return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException() {
        Map<String, Object> body = new HashMap<>();
        body.put(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy / HH:mm:ss")),  "USER NOT FOUND");
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
