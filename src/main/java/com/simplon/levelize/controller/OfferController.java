package com.simplon.levelize.controller;

import com.simplon.levelize.dto.LocationDto;
import com.simplon.levelize.dto.MinMaxDto;
import com.simplon.levelize.dto.OfferDto;
import com.simplon.levelize.service.GenericService;
import com.simplon.levelize.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offers")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:4200"})
public class OfferController extends GenericController<OfferDto, Long> {

    private final OfferService service;


    @Override
    protected GenericService<OfferDto, Long> getService() {
        return service;
    }

    @GetMapping("/locations")
    public ResponseEntity<Page<LocationDto>> getLocations(Pageable pageable, @RequestParam(required = false) String search, @RequestParam(required = false) String title) {
        try {
            logger.info("GET {}/locations - search: {}, title: {}", getEndpoint(), search, title);
            Page<LocationDto> locations = service.getLocations(pageable, search, title);
            logger.info("GET {}/locations - {} locations found", getEndpoint(), locations.getTotalElements());
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            logger.info("GET {}/locations - error: {}", getEndpoint(), e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/titles")
    public ResponseEntity<Page<String>> getTitles(Pageable pageable, @RequestParam(required = false) String search) {
        try {
            logger.info("GET {}/titles - search: {}", getEndpoint(), search);
            Page<String> titles = service.getTitles(pageable, search);
            logger.info("GET {}/titles - {} titles found", getEndpoint(), titles.getTotalElements());
            return ResponseEntity.ok(titles);
        } catch (Exception e) {
            logger.info("GET {}/titles - error: {}", getEndpoint(), e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/min-max")
    public ResponseEntity<MinMaxDto> getMinMidMax(@RequestParam(required = false) String title, @RequestParam(required = false) String location) {
        try {
            logger.info("GET {}/min-max", getEndpoint());
            MinMaxDto minMidMax = service.getMinMidMaxSalary(title, location);
            logger.info("GET {}/min-max - min: {}, max: {}, total: {}, count: {}", getEndpoint(), minMidMax.getMin(), minMidMax.getMax(), minMidMax.getTotal(), minMidMax.getCount());
            return ResponseEntity.ok(minMidMax);
        } catch (Exception e) {
            logger.info("GET {}/min-max - error: {}", getEndpoint(), e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
