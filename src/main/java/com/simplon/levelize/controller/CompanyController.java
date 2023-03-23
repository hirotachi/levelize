package com.simplon.levelize.controller;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
public class CompanyController extends GenericController<CompanyDto, Long> {

    private final CompanyService companyService;
    @Override
    protected GenericService<CompanyDto, Long> getService() {
        return companyService;
    }
}
