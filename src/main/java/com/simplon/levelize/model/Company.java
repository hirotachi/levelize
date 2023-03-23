package com.simplon.levelize.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String logo;
    private String industry;
    private String headquarters;
    private Integer size;
    private String website;

    @ToString.Exclude
    @OneToMany(mappedBy = "company")
    private Set<JobLevel> jobLevels;

    @ToString.Exclude
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;

}

