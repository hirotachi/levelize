package com.simplon.levelize.repository;

import com.simplon.levelize.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface JobLevelRepository extends GenericRepository<JobLevel, Long>{
    @Query("SELECT c FROM JobLevel c WHERE c.title LIKE %:search%")
    Page<JobLevel> search(@Param("search") String search, Pageable pageable);

}
