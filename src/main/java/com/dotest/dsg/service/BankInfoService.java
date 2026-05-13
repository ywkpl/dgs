package com.dotest.dsg.service;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.FullQueryBuilder;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankInfoPagedQuery;
import com.dotest.dsg.codegen.types.BankInfoQuery;
import com.dotest.dsg.codegen.types.CreateBankInfo;
import com.dotest.dsg.codegen.types.UpdateBankInfo;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entityview.BankInfoUpdateView;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.PaginatedResult;
import com.dotest.dsg.mapper.BankInfoMapper;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankInfoService {
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final BankInfoMapper bankInfoMapper;
    private final GraphQLEntityViewSupport entityViewSupport;

    public BankInfoService(CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, BankInfoMapper bankInfoMapper, GraphQLEntityViewSupport entityViewSupport) {
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.bankInfoMapper = bankInfoMapper;
        this.entityViewSupport = entityViewSupport;
    }

    public BankInfoView get(Long id, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        cb.where("id").eq().value(id);

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting = getEntityViewSetting(BankInfoView.class, dfe);
        FullQueryBuilder<BankInfoView, ?> test = evm.applySetting(setting, cb);
        return test.getSingleResultOrNull();
    }

    public List<BankInfoView> getList(BankInfoQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        if (Strings.isNotBlank(query.getName())) {
            cb.where("name").like().value("%" + query.getName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getCode())) {
            cb.where("code").eq().value(query.getCode());
        }

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting = getEntityViewSetting(BankInfoView.class, dfe);

        return evm.applySetting(setting, cb).getResultList();
    }

    public PaginatedResult<BankInfoView> getPage(BankInfoPagedQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        if (Strings.isNotBlank(query.getName())) {
            cb.where("name").like().value("%" + query.getName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getCode())) {
            cb.where("code").eq().value(query.getCode());
        }
        cb.orderBy("id", true);

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting = getEntityViewSetting(BankInfoView.class, dfe);
        FullQueryBuilder<BankInfoView, ?> queryBuilder = evm.applySetting(setting, cb);

        //分頁[如果有分頁對象/接口]
        //TODO 需要加入接口判斷, graphql參數和返回值定義有沒有通用方法呢？
        int first = (query.getPage() - 1) * query.getSize();
        PagedList<BankInfoView> resultList = queryBuilder.page(first, query.getSize().intValue())
                .getResultList();
        PaginatedResult<BankInfoView> result = PaginatedResult.<BankInfoView>builder()
                .content(resultList.stream().toList())
                .totalElements((int) resultList.getTotalSize())
                .totalPages(resultList.getTotalPages())
                .pageNumber(resultList.getPage())
                .build();
        return result;
    }

    @Transactional
    public Boolean delete(Long id) {
        int count = cbf.delete(em, BankInfo.class)
                .where("id").eq().value(id)
                .executeUpdate();
        return count > 0;
    }

    @Transactional
    public BankInfoView update(UpdateBankInfo input) {
        BankInfoUpdateView infoView = evm.getReference(BankInfoUpdateView.class, Long.parseLong(input.getId()));
        bankInfoMapper.updateView(input, infoView);
        evm.save(em, infoView);
        return evm.find(em, BankInfoView.class, input.getId());
    }

    @Transactional
    public BankInfoView create(CreateBankInfo input) {
        BankInfoUpdateView view = bankInfoMapper.toCreate(input);
        evm.save(em, view);
        return evm.find(em, BankInfoView.class, view.getId());
    }

    /// TODO 後緒修改為直接從泛型中獲取類型
    private <T> EntityViewSetting<T, CriteriaBuilder<T>> getEntityViewSetting(Class<T> clazz, DgsDataFetchingEnvironment dfe) {
        return dfe == null ?
                EntityViewSetting.create(clazz) :
                entityViewSupport.createSetting(clazz, dfe);
    }
}
