package com.unravel.searchsystem.service;

import com.unravel.searchsystem.dtos.SearchRequestDto;

/**
 * Created by anurag on 22/3/21.
 */
public interface SearchService {
    String search(SearchRequestDto searchRequestDto);
}
