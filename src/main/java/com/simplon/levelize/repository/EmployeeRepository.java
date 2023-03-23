package com.simplon.levelize.repository;

import com.simplon.levelize.model.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeRepository extends GenericRepository<Employee, Long> {
    @Query("SELECT c FROM Employee c WHERE c.location LIKE %:search% or c.position LIKE %:search%")
    Page<Employee> search(@Param("search") String search, Pageable pageable);
}
