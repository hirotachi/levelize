package com.simplon.levelize.service;

import com.simplon.levelize.model.*;
import com.simplon.levelize.repository.*;
import lombok.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;


@RequiredArgsConstructor
public abstract class GenericServiceImpl<MODEL, DTO, ID > implements GenericService<DTO, ID> {
    private ModelMapper modelMapper;

    private Class<DTO> dtoClass;
    private Class<MODEL> modelClass;

    protected abstract GenericRepository<MODEL, ID> getRepository();


    @Override
    public Page<DTO> findAll(Pageable pageable, String search) {
        if (search == null || search.isBlank()) {
            return getRepository().findAll(pageable).map(this::convertToDto);
        } else {
            return getRepository().search(search, pageable).map(this::convertToDto);
        }
    }



    @Override
    public DTO findById(ID id) {
        return getRepository().findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException(modelClass.getSimpleName() + " not found with id " + id));
    }

    @Override
    public DTO create(DTO dto) {
        MODEL model = convertToModel(dto);
        return convertToDto(getRepository().save(model));
    }

    @Override
    public DTO update(ID id, DTO dto) {
        MODEL model = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException(modelClass.getSimpleName() + " not found with id " + id));
        modelMapper.map(dto, model);
        MODEL updatedModel = getRepository().save(model);
        return convertToDto(updatedModel);
    }

    @Override
    public void delete(ID id) {
        MODEL model = getRepository().findById(id)
                .orElseThrow(() -> new RuntimeException(modelClass.getSimpleName() + " not found with id " + id));
        getRepository().delete(model);
    }

    private DTO convertToDto(MODEL model) {
        return modelMapper.map(model, dtoClass);
    }

    private MODEL convertToModel(DTO dto) {
        return modelMapper.map(dto, modelClass);
    }
}
