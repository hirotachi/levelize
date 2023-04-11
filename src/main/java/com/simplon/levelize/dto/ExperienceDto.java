package com.simplon.levelize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDto implements Serializable {
    private Long total;
    private Long atCompany;
}
