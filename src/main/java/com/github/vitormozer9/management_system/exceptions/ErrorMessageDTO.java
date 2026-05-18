package com.github.vitormozer9.management_system.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor 
public class ErrorMessageDTO {
    
    private String message;
    private String field;
}
