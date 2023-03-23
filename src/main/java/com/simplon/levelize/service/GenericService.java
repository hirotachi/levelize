package com.simplon.levelize.service;

import org.springframework.data.domain.*;

import java.util.*;

public interface GenericService<DTO, ID> {
    Page<DTO> findAll(Pageable pageable, String search);
    DTO findById(ID id);
    DTO create(DTO dto);
    DTO update(ID id, DTO dto);
    void delete(ID id);
}
