package com.vaishnavi.springbootwebtutorial.springbootwebtutorial.exceptios;

public class ResourceNotFound  extends RuntimeException{
    public ResourceNotFound(String message) {
        super(message);
    }
}
