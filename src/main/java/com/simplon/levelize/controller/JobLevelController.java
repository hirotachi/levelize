package com.simplon.levelize.controller;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/joblevels")
@RequiredArgsConstructor
public class JobLevelController extends GenericController<JobLevelDto, Long> {

    private final JobLevelService companyService;

    @Override
    protected GenericService<JobLevelDto, Long> getService() {
        return companyService;
    }
}