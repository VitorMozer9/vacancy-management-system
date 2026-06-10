package com.github.vitormozer9.management_system.modules.candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    
    private UUID id;

    @Schema(example = "Vitor Mozer")
    private String name;

    @Schema(example = "Java Developer")
    private String description;

    @Schema(example = "vitor")
    private String username;

    @Schema(example = "vitor_javaDev@gmail.com")
    private String email;
}
