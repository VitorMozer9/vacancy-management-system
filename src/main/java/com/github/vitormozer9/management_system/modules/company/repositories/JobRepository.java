package com.github.vitormozer9.management_system.modules.company.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vitormozer9.management_system.modules.company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID>{

    List<JobEntity> findByDescriptionContainingIgnoreCase(String filter);
    Optional<JobEntity> findById(UUID id);
}
