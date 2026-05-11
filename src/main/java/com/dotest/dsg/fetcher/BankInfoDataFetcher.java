package com.dotest.dsg.fetcher;

import com.blazebit.persistence.*;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.ConvertOption;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.BankInfoQuery;
import com.dotest.dsg.codegen.types.CreateBankInfo;
import com.dotest.dsg.codegen.types.UpdateBankInfo;
import com.dotest.dsg.config.PatchMapper;
import com.dotest.dsg.entity.BankAccount;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entityview.BankAccountView;
import com.dotest.dsg.entityview.BankInfoUpdateView;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.mapper.BankInfoMapper;
import com.dotest.dsg.repository.BankInfoRepository;
import com.netflix.graphql.dgs.*;
import graphql.schema.DataFetchingEnvironment;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@DgsComponent
public class BankInfoDataFetcher {

    private final BankInfoRepository bankInfoRepository;
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final BankInfoMapper bankInfoMapper;

    public BankInfoDataFetcher(BankInfoRepository bankInfoRepository, CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, BankInfoMapper bankInfoMapper) {
        this.bankInfoRepository = bankInfoRepository;
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.bankInfoMapper = bankInfoMapper;
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
    public BankInfoView bankInfo(@InputArgument String id, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        cb.where("id").eq().value(Long.parseLong(id));

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting;
        if (dfe == null) {
            setting = EntityViewSetting.create(BankInfoView.class);
        } else {
            setting = graphQLEntityViewSupport.createSetting(BankInfoView.class, dfe);
        }
        FullQueryBuilder<BankInfoView, ?> test = evm.applySetting(setting, cb);
        return test.getSingleResultOrNull();
    }

    @Autowired
    private PatchMapper patchMapper;

    @DgsMutation
    @Transactional
    public BankInfoView updateBankInfo(@InputArgument UpdateBankInfo input, DgsDataFetchingEnvironment dfe) {

//            evm.convert(input, BankInfoView.class, ConvertOption.CREATE_NEW)

        BankInfoUpdateView infoView = evm.getReference(BankInfoUpdateView.class, Long.parseLong(input.getId()));
        bankInfoMapper.updateView(input, infoView);
        evm.save(em, infoView);
        return evm.find(em, BankInfoView.class, input.getId());

//        BankInfoView bankInfoView = evm.getReference(BankInfoView.class, Long.parseLong(input.getId()));
//        patchMapper.patch(input, bankInfoView);
//
//        evm.save(em, bankInfoView);
//        return getBankInfo(Long.parseLong(input.getId()), dfe);
    }

    @DgsMutation
    @Transactional
    public BankInfoView createBankInfo(@InputArgument CreateBankInfo input, DgsDataFetchingEnvironment dfe) {
        BankInfoUpdateView view = bankInfoMapper.toCreate(input);

//        BankInfoUpdateView view = evm.create(BankInfoUpdateView.class);
//        view.setId(ZonedDateTime.now().toInstant().toEpochMilli());
//        patchMapper.patch(input, view);
        evm.save(em, view);
        Long id = view.getId();
        return evm.find(em, BankInfoView.class, id);

//        BankInfoView bankInfoView = evm.getReference(BankInfoView.class, Long.parseLong(input.getId()));
//        patchMapper.patch(input, bankInfoView);
//
//        evm.save(em, bankInfoView);
//        return getBankInfo(Long.parseLong(input.getId()), dfe);
    }

    public BankInfoView getBankInfo(Long id, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class);
        cb.where("id").eq().value(id);

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting;
        if (dfe == null) {
            setting = EntityViewSetting.create(BankInfoView.class);
        } else {
            setting = graphQLEntityViewSupport.createSetting(BankInfoView.class, dfe);
        }
        FullQueryBuilder<BankInfoView, ?> test = evm.applySetting(setting, cb);
        return test.getSingleResultOrNull();
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
