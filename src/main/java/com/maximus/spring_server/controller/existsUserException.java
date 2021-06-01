package com.maximus.spring_server.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

public class existsUserException extends Throwable {
    public existsUserException(Enum<HttpStatus> httpStatus, String s) {
        if (httpStatus == HttpStatus.BAD_REQUEST){
            System.out.println(s);
        }
    }
}
