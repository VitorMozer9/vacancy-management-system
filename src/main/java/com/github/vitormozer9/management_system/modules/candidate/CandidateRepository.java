package com.github.vitormozer9.management_system.modules.candidate;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity,UUID>{
    Optional<CandidateEntity> findByUsernameOrEmail(String usernemane, String email);
}
