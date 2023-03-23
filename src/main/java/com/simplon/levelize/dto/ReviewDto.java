package com.simplon.levelize.dto;

import java.io.*;
import java.sql.*;

/**
 * A DTO for the {@link com.simplon.levelize.model.Review} entity
 */
public record ReviewDto(Long id, Integer rating, String reviewText, Date date) implements Serializable {
}