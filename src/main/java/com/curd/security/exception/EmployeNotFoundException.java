package com.curd.security.exception;

public class EmployeNotFoundException extends RuntimeException{
    public EmployeNotFoundException(String message){
        super(message);
    }
}
