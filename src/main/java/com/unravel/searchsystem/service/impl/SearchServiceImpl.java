package com.unravel.searchsystem.service.impl;

import com.unravel.searchsystem.dtos.SearchRequestDto;
import com.unravel.searchsystem.helper.SearchHelper;
import com.unravel.searchsystem.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by anurag on 22/3/21.
 */
@Slf4j
@Service
public class SearchServiceImpl implements SearchService {

    private static final String INDEX = "unravel";
    private static final String TYPE = "places";

    @Autowired
    private Client client;

    @Autowired
    private SearchHelper searchHelper;

    @Override
    public String search(SearchRequestDto searchRequestDto) {
        QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery(searchRequestDto.getQuery());
        SearchRequestBuilder requestBuilder = client.prepareSearch(INDEX)
                .setTypes(TYPE)
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(queryStringQueryBuilder)
                .setSize(10);
        log.info("RequestBuilder requested Query is {} ", requestBuilder);
        SearchResponse response = requestBuilder.execute().actionGet();
        long hitCount = response.getHits().getTotalHits();
        log.info("Found hits {} ", hitCount);
        return response.toString();
    }
}
