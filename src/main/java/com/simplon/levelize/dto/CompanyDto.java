package com.simplon.levelize.dto;

import java.io.*;

/**
 * A DTO for the {@link com.simplon.levelize.model.Company} entity
 */
public record CompanyDto(Long id, String name, String logo, String industry, String headquarters, Integer size,
                         String website) implements Serializable {
}