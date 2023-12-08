package com.ashwani.jobapp.company.impl;

import com.ashwani.jobapp.company.Company;
import com.ashwani.jobapp.company.CompanyRepository;
import com.ashwani.jobapp.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company getOne(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company updatedCompany) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if(optionalCompany.isPresent()){
            Company company = optionalCompany.get();
            company.setName(updatedCompany.getName());
            company.setLocation(updatedCompany.getLocation());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeCompany(Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if(companyOptional.isPresent()){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
