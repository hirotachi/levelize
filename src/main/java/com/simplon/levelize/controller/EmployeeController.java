package com.simplon.levelize.controller;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController extends GenericController<EmployeeDto, Long> {

    private final EmployeeService companyService;

    @Override
    protected GenericService<EmployeeDto, Long> getService() {
        return companyService;
    }
}
