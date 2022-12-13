package com.Integrador.exception;

public class NotFoundException extends Exception{
    public NotFoundException(){
        super("Resource not found");
    }
    public NotFoundException(String message){
        super(message);
    }
}
