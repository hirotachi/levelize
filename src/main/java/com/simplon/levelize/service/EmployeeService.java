package com.simplon.levelize.service;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class EmployeeService extends GenericServiceImpl<Employee, EmployeeDto, Long>{
    @Autowired
    private EmployeeRepository repository;
    @Override
    protected EmployeeRepository getRepository() {
        return repository;
    }
}
