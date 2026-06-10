package com.github.vitormozer9.management_system.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vancancy for java developer entry-level I", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "Gym pass, Health plan", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "Entry-Level I", requiredMode = RequiredMode.REQUIRED)
    private String level;
    
}
