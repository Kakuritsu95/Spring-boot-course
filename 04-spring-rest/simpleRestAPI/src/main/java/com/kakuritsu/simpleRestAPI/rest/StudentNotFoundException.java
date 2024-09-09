package com.kakuritsu.simpleRestAPI.rest;

public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String message){
        super(message);
    }
}
