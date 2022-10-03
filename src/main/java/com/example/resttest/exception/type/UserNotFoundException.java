package com.example.resttest.exception.type;


public  class UserNotFoundException extends RuntimeException {
   public UserNotFoundException(long id) {
      super("User with id " + id + " not found!");
   }

   public UserNotFoundException() {
      super("Cannot create not valid user!");
   }

}