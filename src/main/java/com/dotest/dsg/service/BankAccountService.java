package com.dotest.dsg.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.FullQueryBuilder;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankAccountQuery;
import com.dotest.dsg.entity.BankAccount;
import com.dotest.dsg.entityview.BankAccountView;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final GraphQLEntityViewSupport entityViewSupport;

    public BankAccountService(CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, GraphQLEntityViewSupport entityViewSupport) {
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.entityViewSupport = entityViewSupport;
    }

    public BankAccountView getBankAccount(Long id, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
        cb.where("id").eq().value(id);

        EntityViewSetting<BankAccountView, CriteriaBuilder<BankAccountView>> setting;
        if (dfe == null) {
            setting = EntityViewSetting.create(BankAccountView.class);
        } else {
            setting = entityViewSupport.createSetting(BankAccountView.class, dfe);
        }
        FullQueryBuilder<BankAccountView, ?> test = evm.applySetting(setting, cb);
        return test.getSingleResultOrNull();
    }

    public List<BankAccountView> getList(BankAccountQuery query, DgsDataFetchingEnvironment dfe){
        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
        if (Strings.isNotBlank(query.getAccountName())) {
            cb.where("accountName").like().value("%" + query.getAccountName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getAccountNo())) {
            cb.where("accountNo").eq().value(query.getAccountNo());
        }
        cb.orderBy("id", true);

        EntityViewSetting<BankAccountView, CriteriaBuilder<BankAccountView>> setting;
        if (dfe == null) {
            setting = EntityViewSetting.create(BankAccountView.class);
        } else {
            setting = entityViewSupport.createSetting(BankAccountView.class, dfe);
        }

        FullQueryBuilder<BankAccountView, ?> test = evm.applySetting(setting, cb);
        //如果啥就分頁[可行]
        PagedList<BankAccountView> resultList = test.page(0, 5)
                .getResultList();
        return resultList;
    }

    public PagedList<BankAccountView> getPage(BankAccountQuery query, DgsDataFetchingEnvironment dfe){
        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
        if (Strings.isNotBlank(query.getAccountName())) {
            cb.where("accountName").like().value("%" + query.getAccountName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getAccountNo())) {
            cb.where("accountNo").eq().value(query.getAccountNo());
        }
        cb.orderBy("id", true);

        EntityViewSetting<BankAccountView, CriteriaBuilder<BankAccountView>> setting;
        if (dfe == null) {
            setting = EntityViewSetting.create(BankAccountView.class);
        } else {
            setting = entityViewSupport.createSetting(BankAccountView.class, dfe);
        }

        FullQueryBuilder<BankAccountView, ?> test = evm.applySetting(setting, cb);
        //如果啥就分頁[可行]
        PagedList<BankAccountView> resultList = test.page(0, 5)
                .getResultList();
        return resultList;
    }
}
