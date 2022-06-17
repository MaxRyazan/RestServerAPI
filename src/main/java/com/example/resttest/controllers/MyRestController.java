package com.example.resttest.controllers;


import com.example.resttest.models.MyUser;
import com.example.resttest.service.impl.MyUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RequestMapping("/api")
@RestController

public class MyRestController {
    private final MyUserServiceImpl userService;
    @Autowired
    public MyRestController(MyUserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> showAll() {
        return userService.showAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> showOneById(@PathVariable long id) {
        return userService.showOneUser(id);
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addNewUser(@RequestBody MyUser myUser) {
     return userService.create(myUser);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody MyUser myUser) {
      return  userService.update(myUser);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.delete(id);
    }
}
