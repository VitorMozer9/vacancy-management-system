package com.github.vitormozer9.management_system.modules.candidate.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vitormozer9.management_system.modules.candidate.entities.ApplyJobEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID>{
    
}
