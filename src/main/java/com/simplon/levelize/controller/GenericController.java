package com.simplon.levelize.controller;

import com.simplon.levelize.service.GenericService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class GenericController<DTO, ID> {

    protected final Logger logger = LoggerFactory.getLogger(GenericController.class);

    protected abstract GenericService<DTO, ID> getService();

    @GetMapping
    public ResponseEntity<Page<DTO>> findAll(Pageable pageable, @RequestParam(required = false) String search) {
        logger.info("GET {} - search: {}", getEndpoint(), search);
        Page<DTO> entities = getService().findAll(pageable, search);

        logger.info("GET {} - {} entities found", getEndpoint(), entities.getTotalElements());
        return ResponseEntity.ok(entities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DTO> findById(@PathVariable ID id) {
        try {
            logger.info("GET {} - id: {}", getEndpoint(), id);
            DTO dto = getService().findById(id);
            logger.info("GET {} - id: {} - entity found", getEndpoint(), id);
            return ResponseEntity.ok(dto);
        } catch (EntityNotFoundException e) {
            logger.info("GET {} - id: {} - entity not found", getEndpoint(), id);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.info("GET {} - id: {} - error", getEndpoint(), id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<DTO> create(@RequestBody DTO dto) {
        try {
            logger.info("POST {} - entity: {}", getEndpoint(), dto);
            DTO createdDto = getService().create(dto);
            logger.info("POST {} - entity: {} - entity created", getEndpoint(), dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdDto);
        } catch (EntityExistsException e) {
            logger.info("POST {} - entity: {} - entity already exists", getEndpoint(), dto);
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } catch (Exception e) {
            logger.info("POST {} - entity: {} - error {}", getEndpoint(), dto, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto) {
        try {
            logger.info("PUT {} - id: {} - entity: {}", getEndpoint(), id, dto);
            DTO updatedDto = getService().update(id, dto);
            logger.info("PUT {} - id: {} - entity: {} - entity updated", getEndpoint(), id, dto);
            return ResponseEntity.ok(updatedDto);
        } catch (EntityNotFoundException e) {
            logger.info("PUT {} - id: {} - entity: {} - entity not found", getEndpoint(), id, dto);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.info("PUT {} - id: {} - entity: {} - error", getEndpoint(), id, dto);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable ID id) {
        try {
            logger.info("DELETE {} - id: {}", getEndpoint(), id);
            getService().delete(id);
            logger.info("DELETE {} - id: {} - entity deleted", getEndpoint(), id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            logger.info("DELETE {} - id: {} - entity not found", getEndpoint(), id);
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.info("DELETE {} - id: {} - error", getEndpoint(), id);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    protected String getEndpoint() {
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
        return requestMapping.value()[0];
    }
}
