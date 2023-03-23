package com.simplon.levelize.model;

import jakarta.persistence.*;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.mapping.*;

import java.util.Set;

@Builder
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "job_level")
@NoArgsConstructor
public class JobLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    private String title;
    private Integer levelNumber;
    private String equivalentLevel;

    @ToString.Exclude
    @OneToMany(mappedBy = "jobLevel")
    private Set<Employee> employees;

}

