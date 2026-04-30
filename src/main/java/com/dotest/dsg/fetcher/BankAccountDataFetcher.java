package com.dotest.dsg.fetcher;

import com.blazebit.persistence.*;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankAccountQuery;
import com.dotest.dsg.entity.BankAccount;
import com.dotest.dsg.entityview.BankAccountView;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.PagedResult;
import com.dotest.dsg.entityview.PaginatedResult;
import com.dotest.dsg.repository.BankAccountRepository;
import com.dotest.dsg.service.BankAccountService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@DgsComponent
public class BankAccountDataFetcher {

    private final BankAccountRepository bankAccountRepository;
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;

    public BankAccountDataFetcher(BankAccountRepository bankAccountRepository, CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm) {
        this.bankAccountRepository = bankAccountRepository;
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
    }

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private GraphQLEntityViewSupport graphQLEntityViewSupport;


    @Autowired
    private PaginationHelper paginationHelper;

//    @DgsQuery
//    public PaginatedResult<BankAccountView> bankAccountPaged(@InputArgument Integer page, @InputArgument Integer size, DgsDataFetchingEnvironment dfe){
//        return paginationHelper.fetchPage(BankAccountView.class, page, size);
//    }

//    @DgsQuery
//    public PaginatedResult<BankAccountView> bankAccountPaged(@InputArgument Integer page, @InputArgument Integer size, DgsDataFetchingEnvironment dfe) {
//        // 1. 创建基础查询
//        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
//        cb.orderBy("id", true);
//
//        EntityViewSetting<BankAccountView, ?> setting = graphQLEntityViewSupport
//                .createPaginatedSetting(BankAccountView.class, dfe, "content");
//        //graphQLEntityViewSupport.createSetting(BankAccountView.class, dfe, "content");
//

    /// /        graphQLEntityViewSupport.applyFetches(dfe, setting, "content");
//
//        int first = (page - 1) * size;
//
//        // 3. 执行分页查询 (Blaze-Persistence 核心)
//        PagedList<BankAccountView> pagedList = evm.applySetting(setting, cb)
//                .page(first, size.intValue())
//                .getResultList();
//
//        return PaginatedResult.<BankAccountView>builder()
//                .content(pagedList)
//                .totalPages(pagedList.getTotalPages())
//                .totalElements(pagedList.getTotalSize())
//                .pageNumber(pagedList.getPage())
//                .build();
//    }
    @DgsQuery
    public List<BankAccountView> bankAccounts(@InputArgument BankAccountQuery query, DgsDataFetchingEnvironment dfe) {
        return bankAccountService.getList(query, dfe);
    }

//    @DgsQuery
//    public PagedList<BankAccountView> bankAccountPage(@InputArgument BankAccountQuery query, DgsDataFetchingEnvironment dfe) {
//        return bankAccountService.getPage(query, dfe);
//    }

//    @DgsQuery
//    public List<BankAccountView> bankAccounts(@InputArgument BankAccountQuery query, DgsDataFetchingEnvironment dfe) {
//        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
//        if (Strings.isNotBlank(query.getName())) {
//            cb.where("name").like().value("%" + query.getName() + "%").noEscape();
//        }
//        if (Strings.isNotBlank(query.getCode())) {
//            cb.where("code").eq().value(query.getCode());
//        }
//        cb.orderBy("id", true);
////        cb.where("name").like().value("%中興新村%").noEscape();
//
////        if(dfe.containsArgument("name")){
//
////        }
////        if(dfe.containsArgument("code")){
////            cb.where("code").eq().value(dfe.getArgument("code"));
////        }
//
//        EntityViewSetting<BankAccountView, ?> setting = graphQLEntityViewSupport.createSetting(BankAccountView.class, dfe);
//
//        FullQueryBuilder<BankAccountView, ?> test = evm.applySetting(setting, cb);
//        //如果啥就分頁[可行]
//        PagedList<BankAccountView> resultList = test.page(0, 5)
//                .getResultList();
//
//        return resultList;
//

    /// /        return evm.applySetting(setting, cb)
    /// /                .page(0, 20)
    /// /                .getResultList();
//    }
    @DgsQuery
    public BankAccountView bankAccount(@InputArgument String id, DgsDataFetchingEnvironment dfe) {
        return bankAccountService.getBankAccount(Long.parseLong(id), dfe);


//        BankAccountView bankAccountView = evm.find(em, BankAccountView.class, id);
//        return bankAccountView;
    }


//    @DgsQuery
//    public CriteriaBuilder<BankAccount> bankAccountsTest(@InputArgument BankAccountQuery query) {
//        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
//        if (Strings.isNotBlank(query.getName())) {
//            cb.where("name").like().value("%" + query.getName() + "%").noEscape();
//        }
//        if (Strings.isNotBlank(query.getCode())) {
//            cb.where("code").eq().value(query.getCode());
//        }
//        return cb.orderBy("id", true);
//    }
}
