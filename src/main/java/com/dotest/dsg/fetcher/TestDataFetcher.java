package com.dotest.dsg.fetcher;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.PaginatedCriteriaBuilder;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entityview.BankAccountView;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.TestPage;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.persistence.EntityManager;

@DgsComponent
public class TestDataFetcher {
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final GraphQLEntityViewSupport graphQLEntityViewSupport;

    public TestDataFetcher(CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, GraphQLEntityViewSupport graphQLEntityViewSupport) {
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.graphQLEntityViewSupport = graphQLEntityViewSupport;
    }

    @DgsQuery(field = "doIt")
    public TestPage doIt(@InputArgument Integer page, @InputArgument Integer size, DgsDataFetchingEnvironment dfe) {
        System.out.println("Fields: " + dfe.getSelectionSet().getFields());

        CriteriaBuilder<BankInfo> cb = cbf.create(em, BankInfo.class)
                .orderBy("id", true);

        // 只做 selection -> fetch extraction
//        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting =
//                graphQLEntityViewSupport.createSetting(BankInfoView.class, dfe, "content");

//        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting = graphQLEntityViewSupport.createSetting(BankInfoView.class,dfe);
//        graphQLEntityViewSupport.applyFetches(dfe, setting, "content");

        EntityViewSetting<BankInfoView, CriteriaBuilder<BankInfoView>> setting = graphQLEntityViewSupport.createSetting(BankInfoView.class, dfe, "content");
        int first = (page - 1) * size;

        PagedList<BankInfoView> pagedList = evm.applySetting(setting, cb)
                .page(first, size.intValue())
                .getResultList();

        return new TestPage(
                pagedList,
                (int) pagedList.getTotalSize(),
                pagedList.getTotalPages(),
                pagedList.getPage()
        );
    }
}
