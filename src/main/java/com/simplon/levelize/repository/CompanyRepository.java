package com.simplon.levelize.repository;

import com.simplon.levelize.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface CompanyRepository extends GenericRepository<Company, Long>{
    @Query("SELECT c FROM Company c WHERE c.name LIKE %:search%")
    Page<Company> search(@Param("search") String search, Pageable pageable);
}
