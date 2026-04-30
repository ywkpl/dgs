package com.dotest.dsg.entityview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestPage {
    private List<BankInfoView> content;
    private int totalElements;
    private int totalPages;
    private int pageNumber;
}
