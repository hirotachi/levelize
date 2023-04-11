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
public class Compensation {
    private Long base;
    private Long bonus;
    private Long stock;
    private String currency;
}
