package com.simplon.levelize.dto;

import com.simplon.levelize.model.*;

import java.io.*;

/**
 * A DTO for the {@link Salary} entity
 */
public record SalaryDto(Long id, EmployeeDto employee, Double baseSalary, Double stockOptions, Double bonus,
                        String currency) implements Serializable {
}