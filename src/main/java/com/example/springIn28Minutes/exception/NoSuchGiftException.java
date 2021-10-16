package com.example.springIn28Minutes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchGiftException extends RuntimeException{

    public NoSuchGiftException(String s) {
        super(s);
    }
}
