package com.github.vitormozer9.management_system.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.management_system.modules.company.dto.CreateJobDTO;
import com.github.vitormozer9.management_system.modules.company.entities.JobEntity;
import com.github.vitormozer9.management_system.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobUseCase jobUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createJob(@Valid @RequestBody CreateJobDTO createJobDTO,HttpServletRequest request){
        try {
            var companyId = request.getAttribute("company_id");
            //jobEntity.setCompanyId(UUID.fromString(companyId.toString()));

            var jobEntity = JobEntity.builder()
                                     .benefits(createJobDTO.getBenefits())
                                     .companyId(UUID.fromString(companyId.toString()))
                                     .description(createJobDTO.getDescription())
                                     .level(createJobDTO.getLevel())
                                     .build();

            var result = this.jobUseCase.execute(jobEntity);
            return ResponseEntity.ok().body(result);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        
    }
}
