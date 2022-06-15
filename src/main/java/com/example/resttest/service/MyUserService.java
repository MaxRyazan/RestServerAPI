package com.example.resttest.service;

import com.example.resttest.models.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyUserService {

     ResponseEntity<?> showAll();
     ResponseEntity<?> showOneUser(long id);

     ResponseEntity<?> create(MyUser myUser);

     ResponseEntity<?> update(MyUser myUser);

     void delete(long id);
}
