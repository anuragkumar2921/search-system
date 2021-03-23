package com.unravel.searchsystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by anurag on 23/3/21.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchRequestDto {
    private String query;
}
