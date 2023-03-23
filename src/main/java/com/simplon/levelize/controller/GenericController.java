package com.simplon.levelize.controller;

import com.simplon.levelize.repository.*;
import com.simplon.levelize.service.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<DTO, ID> {
    protected abstract GenericService<DTO, ID> getService();

    @GetMapping
    public ResponseEntity<Page<DTO>> findAll(Pageable pageable, @RequestParam(required = false) String search) {
        Page<DTO> entities = getService().findAll(pageable, search);
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        return ResponseEntity.ok(getService().findById(id));
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(getService().create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        return ResponseEntity.ok(getService().update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
