package com.simplon.levelize.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Double baseSalary;
    private Double stockOptions;
    private Double bonus;
    private Double totalCompensation;
    private String currency;

    public Employee getEmployee() {
        return employee;
    }

    // Constructors, getters, and setters
}
