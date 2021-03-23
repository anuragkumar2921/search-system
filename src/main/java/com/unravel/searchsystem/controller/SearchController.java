package com.unravel.searchsystem.controller;

import com.unravel.searchsystem.dtos.SearchRequestDto;
import com.unravel.searchsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by anurag on 22/3/21.
 */
@RestController
@RequestMapping("/v1")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestBody SearchRequestDto query) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(searchService.search(query));
    }
}
