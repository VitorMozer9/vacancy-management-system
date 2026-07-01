package com.github.vitormozer9.management_system.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.vitormozer9.management_system.exceptions.JobNotFoundException;
import com.github.vitormozer9.management_system.exceptions.UserNotFoundException;
import com.github.vitormozer9.management_system.modules.candidate.CandidateRepository;
import com.github.vitormozer9.management_system.modules.candidate.repositories.ApplyJobRepository;
import com.github.vitormozer9.management_system.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // we need , candidate ID and vancancy ID
    public void execute(UUID idCandidate, UUID idJob) {

        this.candidateRepository.findById(idCandidate)
        .orElseThrow(() -> {
            throw new UserNotFoundException();
        });

        this.jobRepository.findById(idJob)
        .orElseThrow(() -> {
            throw new JobNotFoundException();
        });

        


    }
}
