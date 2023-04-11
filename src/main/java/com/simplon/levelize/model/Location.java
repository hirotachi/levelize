package com.simplon.levelize.model;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Embeddable
public class Location {
    private String city;
    private String country;
    private String state;
    private String type; // remote, on-site, etc.
}
