package com.simplon.levelize.controller;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/salaries")
@RequiredArgsConstructor
public class SalaryController extends GenericController<SalaryDto, Long> {

    private final SalaryService companyService;

    @Override
    protected GenericService<SalaryDto, Long> getService() {
        return companyService;
    }
}
