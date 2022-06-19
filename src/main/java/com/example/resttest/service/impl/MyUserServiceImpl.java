package com.example.resttest.service.impl;

import com.example.resttest.exception.type.NoDataException;
import com.example.resttest.exception.type.UserNotFoundException;
import com.example.resttest.models.MyUser;
import com.example.resttest.repository.MyUserRepository;
import com.example.resttest.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MyUserServiceImpl implements MyUserService {

    private final MyUserRepository userRepository;

    @Autowired
    public MyUserServiceImpl(MyUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?>  showAll() {
        List<MyUser> users = userRepository.findAll();
        if (users.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new NoDataException();
        }
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> showOneUser(long id) {
        MyUser myUser =  userRepository.findById(id).orElse(null);
        if(myUser == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw  new UserNotFoundException();
        }
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> create(MyUser myUser) {
            if((myUser == null) ||
                    !(myUser.getId() > 0) ||
                    (myUser.getName() == null) ||
                    (myUser.getLastName()==null) ||
                    (myUser.getEmail() == null) ||
                    (myUser.getPassword() == null))  {
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
                throw  new UserNotFoundException();
            }
        userRepository.save(myUser);
      return  new ResponseEntity<>(myUser, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> update(MyUser myUser) {
        MyUser user = userRepository.findById(myUser.getId()).orElse(null);
        if(user == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw  new UserNotFoundException();
        } else {
            user.setName(myUser.getName());
            user.setLastName(myUser.getLastName());
            user.setEmail(myUser.getEmail());
            user.setPassword(myUser.getPassword());
            userRepository.save(user);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @Override
    public void delete(long id) {
        MyUser userForDelete = userRepository.findById(id).orElse(null);
        if(userForDelete == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw  new UserNotFoundException();
        } else {
            userRepository.delete(userForDelete);
        }
    }
}
