package com.digitalcorewebservices.firstJobApp.company.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digitalcorewebservices.firstJobApp.company.Company;
import com.digitalcorewebservices.firstJobApp.company.CompanyRepository;
import com.digitalcorewebservices.firstJobApp.company.CompanyService;

@Service
public class CompanyServiceImplementation implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImplementation(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCompanyById(Long id, Company updatedCompany) {
        if (companyRepository.existsById(id)) {
            updatedCompany.setId(id);
            companyRepository.save(updatedCompany);
            return true;
        }
        return false;
    }
}
