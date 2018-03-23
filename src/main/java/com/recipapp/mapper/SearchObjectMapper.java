package com.recipapp.mapper;

import com.recipapp.controller.response.SearchResponse;
import com.recipapp.error.MappingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class SearchObjectMapper extends AbstractObjectMapper<Page<?>, SearchResponse> {

    private static final Logger LOG = LoggerFactory.getLogger(SearchObjectMapper.class);

    @Override
    public SearchResponse map(Page<?> input, Class<SearchResponse> clazz) {
        SearchResponse resp = null;
        try {
            resp = clazz.newInstance();
        } catch (Exception ex) {
            LOG.error("Could not map recipe", ex);
            throw new MappingException("Could not map recipe", ex);
        }
        resp.setData(input.getContent());
        resp.setPages(input.getTotalPages());
        resp.setSize(input.getSize());
        return resp;
    }
}
