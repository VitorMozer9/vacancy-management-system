package com.github.vitormozer9.management_system.modules.candidate.entities;

import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "candidate")
public class CandidateEntity {
   
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Schema(example = "August Ferreira", requiredMode = RequiredMode.REQUIRED)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message =  "O campo [username] não pode conter espaços!")
    @Schema(example = "gustgust", requiredMode = RequiredMode.REQUIRED)
    private String username;

    @Email(message = "O campo [email] deve conter um e-email válido")
    @Schema(example = "gust_ferreira@yahoo.com", requiredMode = RequiredMode.REQUIRED)
    private String email;

    @Length(min = 10 , max = 100, message = "A senha deve conter entre 10 e 100 caracteresa")
    @Schema(example = "ferreir@5465", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED)
    private String password;

    @Schema(example = "Java software engineer")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
