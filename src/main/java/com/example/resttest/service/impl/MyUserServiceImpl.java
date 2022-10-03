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
    public ResponseEntity<List<MyUser>>  showAll() {
        List<MyUser> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataException();
        }
            return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<MyUser> showOneUser(long id) {
        MyUser myUser =  userRepository.findById(id).orElse(null);
        if(myUser == null) {
            throw  new UserNotFoundException(id);
        }
        return new ResponseEntity<>(myUser, HttpStatus.OK);
    }
    @Override
    public ResponseEntity<MyUser> create(MyUser myUser) {
            if((myUser == null) ||
                    !(myUser.getId() > 0) ||
                    (myUser.getName() == null) ||
                    (myUser.getLastName()==null) ||
                    (myUser.getEmail() == null) ||
                    (myUser.getPassword() == null))  {
                throw  new UserNotFoundException();
            }
        userRepository.save(myUser);
      return new ResponseEntity<>(myUser, HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<MyUser> update(MyUser myUser) {
        MyUser user = userRepository.findById(myUser.getId()).orElse(null);
        if(user == null) {
            throw  new UserNotFoundException();
        } else {
            user.setName(myUser.getName());
            user.setLastName(myUser.getLastName());
            user.setEmail(myUser.getEmail());
            user.setPassword(myUser.getPassword());
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
    @Override
    public ResponseEntity<MyUser> deleteById(long id) {
        if(isNotExist(id)){
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
        if(isNotExist(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public boolean isNotExist(long id){
        return userRepository.findById(id).isEmpty();
    }
}
