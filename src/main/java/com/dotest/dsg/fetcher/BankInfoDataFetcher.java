package com.dotest.dsg.fetcher;

import com.dotest.dsg.codegen.types.BankInfoPagedQuery;
import com.dotest.dsg.codegen.types.BankInfoQuery;
import com.dotest.dsg.codegen.types.CreateBankInfo;
import com.dotest.dsg.codegen.types.UpdateBankInfo;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.PaginatedResult;
import com.dotest.dsg.service.BankInfoService;
import com.netflix.graphql.dgs.*;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@DgsComponent
public class BankInfoDataFetcher {

    private final BankInfoService bankInfoService;

    public BankInfoDataFetcher(BankInfoService bankInfoService) {
        this.bankInfoService = bankInfoService;
    }

    @DgsQuery
    public BankInfoView bankInfo(@InputArgument String id, DgsDataFetchingEnvironment dfe) {
        return bankInfoService.get(Long.parseLong(id), dfe);
    }

    @DgsQuery
    public List<BankInfoView> bankInfos(@InputArgument BankInfoQuery query, DgsDataFetchingEnvironment dfe) {
        return bankInfoService.getList(query, dfe);
    }

    @DgsQuery
    public PaginatedResult<BankInfoView> bankInfoPage(@InputArgument BankInfoPagedQuery query, DgsDataFetchingEnvironment dfe) {
        return bankInfoService.getPage(query, dfe);
    }

    @DgsMutation
    @Transactional
    public BankInfoView updateBankInfo(@InputArgument UpdateBankInfo input, DgsDataFetchingEnvironment dfe) {
        return bankInfoService.update(input, dfe);
    }

    @DgsMutation
    @Transactional
    public BankInfoView createBankInfo(@InputArgument CreateBankInfo input, DgsDataFetchingEnvironment dfe) {
        return bankInfoService.create(input, dfe);
    }

    @DgsMutation
    @Transactional
    public Boolean deleteBankInfo(@InputArgument String id) {
        return bankInfoService.delete(Long.parseLong(id));
    }
}
