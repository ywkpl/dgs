package com.dotest.dsg.fetcher;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.PaginatedCriteriaBuilder;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankInfoQuery;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.repository.BankInfoRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@DgsComponent
public class BankInfoDataFetcher {

    private final BankInfoRepository bankInfoRepository;
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;

    public BankInfoDataFetcher(BankInfoRepository bankInfoRepository, CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm) {
        this.bankInfoRepository = bankInfoRepository;
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
    }

    @Autowired
    private GraphQLEntityViewSupport graphQLEntityViewSupport;

    @DgsQuery
    public List<BankInfoView> bankInfos(@InputArgument BankInfoQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        if (Strings.isNotBlank(query.getName())) {
            cb.where("name").like().value("%" + query.getName() + "%").noEscape();
        }
        if (Strings.isNotBlank(query.getCode())) {
            cb.where("code").eq().value(query.getCode());
        }
//        cb.where("name").like().value("%中興新村%").noEscape();

//        if(dfe.containsArgument("name")){

//        }
//        if(dfe.containsArgument("code")){
//            cb.where("code").eq().value(dfe.getArgument("code"));
//        }

        EntityViewSetting<BankInfoView, ?> setting = graphQLEntityViewSupport.createSetting(BankInfoView.class, dfe);

        return evm.applySetting(setting, cb)
                .getResultList();
    }

    @DgsQuery
    public BankInfo bankInfo(Long id) {
        return bankInfoRepository.findById(id).orElse(null);
    }

//    @DgsQuery
//    public BankInfoPaged bankInfoPaged(@InputArgument Integer page, @InputArgument Integer size,
//                                       DataFetchingEnvironment dfe) {
//        // 建立 CriteriaBuilder（你的 base query）
//        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class)
//                .orderByAsc("id");   // 或其他排序
//
//        // 使用 Blaze GraphQL integration 根據 selection set 建立 dynamic setting
//        EntityViewSetting<BankInfoView, PaginatedCriteriaBuilder<BankInfoView>> setting =
//                graphQLEntityViewSupport.createPaginatedSetting(BankInfoView.class, dfe, "content");  // "content" 是你分頁欄位的 root
//
//        // 應用 setting 到 query（自動只 select 前端需要的欄位）
//        PaginatedCriteriaBuilder<BankInfoView> paginatedCb = evm.applySetting(setting, cb);
//
//        int first = (page - 1) * size;
//        // 執行查詢
//        PagedList<BankInfoView> pagedList = paginatedCb
//                .page(first, (int) size)
//                .getResultList();
//    }
}
