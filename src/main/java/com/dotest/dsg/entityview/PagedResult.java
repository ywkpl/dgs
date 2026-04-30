package com.dotest.dsg.entityview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagedResult<T> {
    private List<T> content;
    private int total;
    private int size;
    private int page;
    private int totalElements;
    private int totalPages;
}
