package com.simplon.levelize.repository;

import com.simplon.levelize.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface ReviewRepository extends GenericRepository<Review, Long> {
    @Query("SELECT c FROM Review c WHERE c.reviewText LIKE %:search%")
    Page<Review> search(@Param("search") String search, Pageable pageable);
}
