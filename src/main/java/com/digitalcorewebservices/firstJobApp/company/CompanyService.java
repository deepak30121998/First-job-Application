package com.digitalcorewebservices.firstJobApp.company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();
    void createCompany(Company company);
    Company findCompanyById(Long id);
    boolean deleteCompanyById(Long id);
    boolean updateCompanyById(Long id, Company updatedCompany);
}
