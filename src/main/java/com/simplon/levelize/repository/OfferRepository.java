package com.simplon.levelize.repository;

import com.simplon.levelize.dto.LocationDto;
import com.simplon.levelize.dto.MinMaxDto;
import com.simplon.levelize.model.Offer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends GenericRepository<Offer, Long> {

    @Query("SELECT c FROM Offer c " +
            "WHERE LOWER(c.company.name) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.location.country) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.location.city) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.location.state) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.tag) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<Offer> search(@Param("search") String search, Pageable pageable);


    @Query("SELECT distinct new com.simplon.levelize.dto.LocationDto(c.location.city, c.location.country, c.location.state, c.location.type) FROM Offer c " +
            "WHERE (LOWER(c.location.country) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.location.city) LIKE LOWER(CONCAT('%', :search, '%')) " +
            "OR LOWER(c.location.state) LIKE LOWER(CONCAT('%', :search, '%')) OR :search IS NULL) " +
            "AND (LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL)")
    Page<LocationDto> searchLocations(@Param("search") String search, @Param("title") String title, Pageable pageable);


    @Query("SELECT DISTINCT c.title FROM Offer c " +
            "WHERE (LOWER(c.title) LIKE LOWER(CONCAT('%', :search, '%')) OR :search IS NULL)")
    Page<String> searchTitles(@Param("search") String search, Pageable pageable);


    @Query("SELECT new com.simplon.levelize.dto.MinMaxDto(MIN(c.compensation.base + c.compensation.bonus + c.compensation.stock)," +
            "MAX(c.compensation.base + c.compensation.bonus + c.compensation.stock)," +
            "SUM(c.compensation.base + c.compensation.bonus + c.compensation.stock)," +
            "COUNT(c.id)) FROM Offer c " +
            "WHERE (LOWER(c.title) LIKE LOWER(CONCAT('%', :title, '%')) OR :title IS NULL) " +
            "AND (LOWER(c.location.country) LIKE LOWER(CONCAT('%', :location, '%')) " +
            "OR LOWER(c.location.city) LIKE LOWER(CONCAT('%', :location, '%')) " +
            "OR LOWER(c.location.state) LIKE LOWER(CONCAT('%', :location, '%')) OR :location IS NULL)")
    MinMaxDto getMinMidMaxSalary(@Param("title") String title, @Param("location") String location);
}
