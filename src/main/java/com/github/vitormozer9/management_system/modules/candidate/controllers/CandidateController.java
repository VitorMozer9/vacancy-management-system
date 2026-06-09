package com.github.vitormozer9.management_system.modules.candidate.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.management_system.modules.candidate.CandidateEntity;
import com.github.vitormozer9.management_system.modules.candidate.useCases.CreateCandidateUseCase;
import com.github.vitormozer9.management_system.modules.candidate.useCases.ListAllJobsByFilterUseCase;
import com.github.vitormozer9.management_system.modules.candidate.useCases.ProfileCandidateUseCase;
import com.github.vitormozer9.management_system.modules.company.entities.JobEntity;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase candidateUserCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private ListAllJobsByFilterUseCase allJobsByFilterUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCandidates(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.candidateUserCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idCandidate = request.getAttribute("candidate_id");

        try {
            var profile = this.profileCandidateUseCase.execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    public List<JobEntity> listAllJobs(@RequestParam String filter){
        return this.allJobsByFilterUseCase.execute(filter);
    }

}
