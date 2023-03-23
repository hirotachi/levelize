package com.simplon.levelize.service;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class CompanyService extends GenericServiceImpl<Company, CompanyDto, Long>{
    @Autowired
    private CompanyRepository repository;
    @Override
    protected CompanyRepository getRepository() {
        return repository;
    }
}
