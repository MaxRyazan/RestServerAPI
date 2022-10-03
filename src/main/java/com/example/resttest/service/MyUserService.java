package com.example.resttest.service;

import com.example.resttest.models.MyUser;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MyUserService {

     ResponseEntity<List<MyUser>> showAll();
     ResponseEntity<MyUser> showOneUser(long id);
     ResponseEntity<MyUser> create(MyUser myUser);
     ResponseEntity<MyUser> update(MyUser myUser);
     void delete(long id);
}
