package com.simplon.levelize.service;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class ReviewService extends GenericServiceImpl<Review, ReviewDto, Long>{
    @Autowired
    private ReviewRepository repository;
    @Override
    protected ReviewRepository getRepository() {
        return repository;
    }
}
