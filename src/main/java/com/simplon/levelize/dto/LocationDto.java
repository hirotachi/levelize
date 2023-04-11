package com.simplon.levelize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto implements Serializable {
    private String city;
    private String country;
    private String state;
    private String type;

    
}
