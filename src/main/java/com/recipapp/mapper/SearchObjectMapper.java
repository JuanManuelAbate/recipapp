package com.recipapp.mapper;

import com.recipapp.controller.response.SearchResponse;
import com.recipapp.error.MappingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;

@Component
public class SearchObjectMapper extends AbstractObjectMapper<PageImpl, SearchResponse> {


    private static final Logger LOG = LoggerFactory.getLogger(SearchObjectMapper.class);

    @Override
    protected Logger getLogger() {
        return LOG;
    }


    @Override
    public SearchResponse doMap(PageImpl input, SearchResponse output) {
        output.setData(input.getContent());
        output.setPages(input.getTotalPages());
        output.setSize(input.getSize());
        output.setTotalElements(input.getTotalElements());
        output.setTotalPages(input.getTotalPages());
        return output;
    }
}
