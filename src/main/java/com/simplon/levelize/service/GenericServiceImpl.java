package com.simplon.levelize.service;

import com.simplon.levelize.repository.GenericRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@RequiredArgsConstructor
public abstract class GenericServiceImpl<MODEL, DTO, ID> implements GenericService<DTO, ID> {
    private final ModelMapper modelMapper = new ModelMapper();

    private final Logger logger = LoggerFactory.getLogger(GenericServiceImpl.class);

    private Class<DTO> dtoClass;
    private Class<MODEL> modelClass;

    public GenericServiceImpl(Class<DTO> dtoClass, Class<MODEL> modelClass) {
        this.dtoClass = dtoClass;
        this.modelClass = modelClass;
    }

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
                .orElseThrow(() -> new EntityNotFoundException(modelClass.getSimpleName() + " not found with id " + id));
    }

    @Override
    public DTO create(DTO dto) {
        MODEL model = convertToModel(dto);
        return convertToDto(getRepository().save(model));
    }

    @Override
    public DTO update(ID id, DTO dto) {
        MODEL model = getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(modelClass.getSimpleName() + " not found with id " + id));
        modelMapper.map(dto, model);
        MODEL updatedModel = getRepository().save(model);
        return convertToDto(updatedModel);
    }

    @Override
    public void delete(ID id) {
        MODEL model = getRepository().findById(id)
                .orElseThrow(() -> new EntityNotFoundException(modelClass.getSimpleName() + " not found with id " + id));
        getRepository().delete(model);
    }

    protected DTO convertToDto(MODEL model) {
        try {
            return modelMapper.map(model, dtoClass);
        } catch (Exception e) {
            logger.error("Error while converting model to dto", e);
            throw e;
        }
    }

    protected MODEL convertToModel(DTO dto) {
        try {
            return modelMapper.map(dto, modelClass);
        } catch (Exception e) {
            logger.error("Error while converting dto to model", e);
            throw e;
        }
    }
}
