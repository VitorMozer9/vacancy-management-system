package com.github.vitormozer9.management_system.exceptions;

public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException() {
        super("Job not found!");
    }
}
