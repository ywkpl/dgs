package com.dotest.dsg.entityview;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class PaginatedResult<T> {
    private List<T> content;
    private int totalElements;
    private int totalPages;
    private int pageNumber;
}
