package com.simplon.levelize.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;
import org.springframework.data.repository.query.*;

@NoRepositoryBean
public interface GenericRepository<MODEL, ID> extends JpaRepository<MODEL, ID> {
    Page<MODEL> search(@Param("search") String search, Pageable pageable);
}

