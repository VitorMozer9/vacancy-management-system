package com.github.vitormozer9.management_system.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User nor found!");
    }
}
