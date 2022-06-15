package com.example.resttest.exception.type;



public  class UserNotFoundException extends RuntimeException {
   public UserNotFoundException(long id) {
      super(String.format("User with Id %d not found", id));
   }
   public UserNotFoundException() {
      super("User with Id %d not found");
   }

}