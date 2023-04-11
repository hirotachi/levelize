package com.simplon.levelize.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MinMaxDto implements Serializable {
    private Long min;
    private Long max;
    private Long total;
    private Long count;
}
