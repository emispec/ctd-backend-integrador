package com.Integrador.exception;

public class AlreadyExistException extends Exception{
    public AlreadyExistException(){
        super("Object already exists");
    }
    public AlreadyExistException(String message){
        super(message);
    }
}
