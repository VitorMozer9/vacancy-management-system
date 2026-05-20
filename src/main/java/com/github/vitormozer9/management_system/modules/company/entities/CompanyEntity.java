package com.github.vitormozer9.management_system.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity(name = "company")
@Data
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message =  "O campo [username] não pode conter espaços!")
    private String username;

    @Email(message = "O campo [email] deve conter um e-email válido")
    private String email;

    @Length(min = 10 , max = 100, message = "A senha deve conter entre 10 e 100 caracteresa")
    private String password;
    
    private String website;
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;
    
}
