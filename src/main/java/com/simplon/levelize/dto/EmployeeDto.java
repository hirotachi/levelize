package com.simplon.levelize.dto;

import com.simplon.levelize.dto.*;
import com.simplon.levelize.model.*;

import java.io.*;
import java.util.*;

/**
 * A DTO for the {@link Employee} entity
 */
public record EmployeeDto(Long id, CompanyDto company, JobLevelDto jobLevel, String position, String location,
                          Integer yearsOfExperience, Integer yearsAtCompany,
                          Set<ReviewDto> reviews) implements Serializable {
}