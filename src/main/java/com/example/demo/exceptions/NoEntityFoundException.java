package com.example.demo.exceptions;

public class NoEntityFoundException extends RuntimeException {

    public NoEntityFoundException(Class<?> entity, Integer id) {
        super(entity.getSimpleName() + " with id " + id + " was not found in the database!");
    }
}
