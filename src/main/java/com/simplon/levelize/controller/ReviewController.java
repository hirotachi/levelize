package com.simplon.levelize.controller;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.service.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController extends GenericController<ReviewDto, Long> {

    private final ReviewService companyService;

    @Override
    protected GenericService<ReviewDto, Long> getService() {
        return companyService;
    }
}
