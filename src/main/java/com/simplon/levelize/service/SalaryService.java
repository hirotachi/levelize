package com.simplon.levelize.service;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class SalaryService extends GenericServiceImpl<Salary, SalaryDto, Long>{
    @Autowired
    private SalaryRepository repository;
    @Override
    protected SalaryRepository getRepository() {
        return repository;
    }
}
