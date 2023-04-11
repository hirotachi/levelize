package com.simplon.levelize.service;

import com.simplon.levelize.dto.LocationDto;
import com.simplon.levelize.dto.MinMaxDto;
import com.simplon.levelize.dto.OfferDto;
import com.simplon.levelize.model.Offer;
import com.simplon.levelize.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends GenericServiceImpl<Offer, OfferDto, Long> {
    @Autowired
    private OfferRepository repository;

    @Override
    protected OfferRepository getRepository() {
        return repository;
    }

    public OfferService(OfferRepository offerRepository) {
        super(OfferDto.class, Offer.class); // Pass the class parameters to the parent constructor
        this.repository = offerRepository;
    }

    public Page<LocationDto> getLocations(Pageable pageable, String search, String title) {
        return repository.searchLocations(search, title, pageable);
    }

    public Page<String> getTitles(Pageable pageable, String search) {
        return repository.searchTitles(search, pageable);
    }

    public MinMaxDto getMinMidMaxSalary(String title, String location) {
        return repository.getMinMidMaxSalary(title, location);
    }
}