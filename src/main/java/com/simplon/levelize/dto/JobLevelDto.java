package com.simplon.levelize.dto;

import java.io.*;

/**
 * A DTO for the {@link com.simplon.levelize.model.JobLevel} entity
 */
public record JobLevelDto(Long id, String title, Integer levelNumber, String equivalentLevel) implements Serializable {
}