package com.github.vitormozer9.management_system.modules.company.repositories;

import java.util.UUID;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.github.vitormozer9.management_system.modules.company.entities.CompanyEntity;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID>{
    Optional<CompanyEntity> findByUsernameOrEmail(String usernemane, String email);
    Optional<CompanyEntity> findByUsername(String companyUsername);
}
