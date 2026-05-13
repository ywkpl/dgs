package com.dotest.dsg.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.FullQueryBuilder;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankAccountPagedQuery;
import com.dotest.dsg.codegen.types.BankAccountQuery;
import com.dotest.dsg.codegen.types.CreateBankAccount;
import com.dotest.dsg.codegen.types.CreateBankInfo;
import com.dotest.dsg.entity.BankAccount;
import com.dotest.dsg.entityview.*;
import com.dotest.dsg.mapper.BankAccountMapper;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankAccountService {
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final GraphQLEntityViewSupport entityViewSupport;
    private final BankAccountMapper bankAccountMapper;

    public BankAccountService(CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, GraphQLEntityViewSupport entityViewSupport, BankAccountMapper bankAccountMapper) {
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.entityViewSupport = entityViewSupport;
        this.bankAccountMapper = bankAccountMapper;
    }

    public BankAccountView get(Long id, DgsDataFetchingEnvironment dfe) {
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

    public List<BankAccountView> getList(BankAccountQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
        if (Strings.isNotBlank(query.getAccountName())) {
            cb.where("accountName").like().value("%" + query.getAccountName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getAccountNo())) {
            cb.where("accountNo").eq().value(query.getAccountNo());
        }
        cb.orderBy("id", true);

        EntityViewSetting<BankAccountView, CriteriaBuilder<BankAccountView>> setting = this.getEntityViewSetting(BankAccountView.class, dfe, false);
        return evm.applySetting(setting, cb).getResultList();
    }

    public PaginatedResult<BankAccountView> getPage(BankAccountPagedQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankAccount> cb = cbf.create(em, BankAccount.class);
        if (Strings.isNotBlank(query.getAccountName())) {
            cb.where("accountName").like().value("%" + query.getAccountName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getAccountNo())) {
            cb.where("accountNo").eq().value(query.getAccountNo());
        }
        cb.orderBy("id", true);

        EntityViewSetting<BankAccountView, CriteriaBuilder<BankAccountView>> setting=getEntityViewSetting(BankAccountView.class, dfe, true);
        FullQueryBuilder<BankAccountView, ?> test = evm.applySetting(setting, cb);

        //分頁[如果有分頁對象/接口]
        //TODO 需要加入接口判斷, graphql參數和返回值定義有沒有通用方法呢？
        int first = (query.getPage() - 1) * query.getSize();
        PagedList<BankAccountView> resultList = test.page(first, query.getSize().intValue())
                .getResultList();
        PaginatedResult<BankAccountView> result = PaginatedResult.<BankAccountView>builder()
                .content(resultList.stream().toList())
                .totalElements((int) resultList.getTotalSize())
                .totalPages(resultList.getTotalPages())
                .pageNumber(resultList.getPage())
                .build();
        return result;
    }

    @Transactional
    public Boolean delete(Long id) {
        int count = cbf.delete(em, BankAccount.class)
                .where("id").eq().value(id)
                .executeUpdate();
        return count > 0;
    }

    @Transactional
    public BankAccountView create(CreateBankAccount input, DgsDataFetchingEnvironment dfe) {
        BankAccountUpdateView view = bankAccountMapper.toCreate(input);
        evm.save(em, view);
        return this.get(view.getId(), dfe);
    }

    /// TODO 後緒修改為直接從泛型中獲取類型
    private <T> EntityViewSetting<T, CriteriaBuilder<T>> getEntityViewSetting(Class<T> clazz, DgsDataFetchingEnvironment dfe, boolean isPage) {
        return dfe == null ?
                EntityViewSetting.create(clazz) :
                isPage ?
                        entityViewSupport.createSetting(clazz, dfe, "content") :
                        entityViewSupport.createSetting(clazz, dfe);
    }

}
