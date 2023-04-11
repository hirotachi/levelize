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
public class Company {
    private String name;
    private String logo;
    private String url;
}
