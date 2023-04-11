package com.simplon.levelize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompensationDto implements Serializable {
    private Long base;
    private Long bonus;
    private Long stock;
    private String currency;
}
