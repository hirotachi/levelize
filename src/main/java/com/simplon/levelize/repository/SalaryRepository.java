package com.simplon.levelize.repository;

import com.simplon.levelize.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface SalaryRepository extends GenericRepository<Salary, Long>{
    @Query("SELECT c FROM Salary c WHERE c.currency LIKE %:search%")
    Page<Salary> search(@Param("search") String search, Pageable pageable);
}
