package com.demo.apiRestFull.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFountException extends RuntimeException{


    public StudentNotFountException(String message){
        super(message);
    }
}
