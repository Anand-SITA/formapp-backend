package com.example.formapp.controller;

import com.example.formapp.model.User;
import com.example.formapp.service.UserService;

import jakarta.validation.Valid;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;

import java.util.*;

@RestController
@RequestMapping("/api/form")
public class FormController {
    @Autowired private UserService service;

    @PostMapping
    public ResponseEntity<?> submitForm(@Valid @RequestBody User user) {
        try {
            User saved = service.saveUser(user);
            return new ResponseEntity<>(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(Map.of("error", e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errs = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
          .forEach(f -> errs.put(f.getField(), f.getDefaultMessage()));
        return new ResponseEntity<>(errs, HttpStatus.BAD_REQUEST);
    }
}
