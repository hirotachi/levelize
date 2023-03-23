package com.simplon.levelize.service;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class JobLevelService extends GenericServiceImpl<JobLevel, JobLevelDto, Long>{
    @Autowired
    private JobLevelRepository repository;
    @Override
    protected JobLevelRepository getRepository() {
        return repository;
    }
}

