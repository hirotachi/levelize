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
@Table(name = "employee")
public class Employee {

    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_level_id", nullable = false)
    private JobLevel jobLevel;

    @ToString.Include
    private String position;
    @ToString.Include
    private String location;
    @ToString.Include
    private Integer yearsOfExperience;
    @ToString.Include
    private Integer yearsAtCompany;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private Salary salary;

    @ToString.Exclude
    @OneToMany(mappedBy = "employee")
    private Set<Review> reviews;

}

