package com.github.vitormozer9.management_system.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException() {
        super("Company not found!");
    }
}
