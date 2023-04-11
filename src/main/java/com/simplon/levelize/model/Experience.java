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
public class Experience {
    private Long total;
    private Long atCompany;
}
