package com.github.vitormozer9.management_system.modules.candidate.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthCandidateResponseDTO {
    
    private String acess_token;
    private Long expires_in;
}
