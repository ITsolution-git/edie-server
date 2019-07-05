package com.securegion.eddieui.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PagedResult<T> {
    private ObjectNode _embedded;
    private ObjectNode page;

    public PagedResult(Page<T> data, String arrayName) {
        ObjectMapper mapper = new ObjectMapper();
        page = mapper.createObjectNode()
                .put("size", data.getSize())
                .put("totalElements", data.getTotalElements())
                .put("totalPages", data.getTotalPages())
                .put("number", data.getNumber());

        _embedded = mapper.createObjectNode();
        ArrayNode rows = _embedded.putArray(arrayName);

        data.getContent().forEach(item -> {
            rows.add(mapper.convertValue(item, ObjectNode.class));
        });
    }

    public PagedResult(List<T> data, String arrayName) {
        ObjectMapper mapper = new ObjectMapper();
        page = mapper.createObjectNode()
                .put("size", data.size())
                .put("totalElements", data.size())
                .put("totalPages", 1)
                .put("number", 1);

        _embedded = mapper.createObjectNode();
        ArrayNode rows = _embedded.putArray(arrayName);

        data.forEach(item -> {
            rows.add(mapper.convertValue(item, ObjectNode.class));
        });
    }
}
