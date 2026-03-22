package com.digitalcorewebservices.firstJobApp.company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/companies")
@RestController
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity <List<Company>> findAll() {
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyById(@PathVariable Long id) {
        Company company = companyService.findCompanyById(id);
        if (company != null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean isDeleted = companyService.deleteCompanyById(id);
        if (isDeleted)
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody Company updatedCompany) {
        boolean updated = companyService.updateCompanyById(id, updatedCompany);
        if (updated) 
            return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
        return new ResponseEntity<>("Company Not Found", HttpStatus.NOT_FOUND);
    }
}
