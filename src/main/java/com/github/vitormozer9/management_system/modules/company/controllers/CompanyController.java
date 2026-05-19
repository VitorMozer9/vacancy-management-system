package com.github.vitormozer9.management_system.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.vitormozer9.management_system.modules.company.entities.CompanyEntity;
import com.github.vitormozer9.management_system.modules.company.useCases.CreateCompanyUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/companys")
public class CompanyController {

    @Autowired
    CreateCompanyUseCase companyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CompanyEntity companyEntity){
        try {
            var result = this.companyUseCase.execute(companyEntity);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
             return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
}
