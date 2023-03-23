package com.simplon.levelize.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Integer rating;
    private String reviewText;

    @Temporal(TemporalType.DATE)
    private Date date;

    // Constructors, getters, and setters
}

