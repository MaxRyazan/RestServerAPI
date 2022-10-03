package com.example.resttest.exception.type;


import java.util.Date;

public class NoDataException extends RuntimeException{

    public NoDataException() {
        super("No data found");
    }
}
