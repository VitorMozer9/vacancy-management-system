package com.github.vitormozer9.management_system.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.management_system.modules.candidate.CandidateEntity;
import com.github.vitormozer9.management_system.modules.candidate.useCases.CreateCandidateUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase candidateUserCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCandidates(@Valid @RequestBody CandidateEntity candidateEntity){
        try {
            var result =  this.candidateUserCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
