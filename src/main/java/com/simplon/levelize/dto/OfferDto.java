package com.simplon.levelize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferDto implements Serializable {
    private Long id;
    private String title;
    private String tag;
    private CompensationDto compensation;
    private CompanyDto company;
    private ExperienceDto experience;
    private Date startDate;
    private LocationDto location;
    private LocalDateTime createdAt;
}

