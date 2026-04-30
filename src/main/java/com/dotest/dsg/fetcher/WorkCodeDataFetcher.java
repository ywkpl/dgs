package com.dotest.dsg.fetcher;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.JoinType;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.WorkCodeQuery;
import com.dotest.dsg.entity.WorkCode;
import com.dotest.dsg.entityview.WorkCodeView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import java.util.List;
import java.util.Optional;

@Slf4j
@DgsComponent
public class WorkCodeDataFetcher {
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;
    private final GraphQLEntityViewSupport graphQLEntityViewSupport;

    public WorkCodeDataFetcher(CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm, GraphQLEntityViewSupport graphQLEntityViewSupport) {
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
        this.graphQLEntityViewSupport = graphQLEntityViewSupport;
    }

    @DgsQuery
    public List<WorkCodeView> workCodes(@InputArgument WorkCodeQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<WorkCode> cb = cbf.create(em, WorkCode.class);
//        cb.join("companyId", "comp", JoinType.INNER);
        Optional.ofNullable(query.getCode())
                .filter(Strings::isNotBlank)
                .ifPresent(code -> cb.where("code").like().value("%" + code + "%").noEscape());

        Optional.ofNullable(query.getName())
                .filter(Strings::isNotBlank)
                .ifPresent(name -> cb.where("name").like().value("%" + name + "%").noEscape());

        Optional.ofNullable(query.getDeptId())
                .ifPresent(deptId -> cb.where("dept.id").eq(deptId));

        Optional.ofNullable(query.getCodes())
                .ifPresent(codes -> cb.where("code").in(codes));

//        Optional.ofNullable(query.getValidAtDate())
//                .ifPresent(validAtDate -> cb.where("validAtDate").ge(validAtDate));

        cb.where("isDeleted").eq(false);
        cb.where("companyId").eq(1L);
        cb.orderBy("id", true);
        EntityViewSetting<WorkCodeView, CriteriaBuilder<WorkCodeView>> setting = graphQLEntityViewSupport.createSetting(WorkCodeView.class, dfe);
        return evm.applySetting(setting, cb)
                .getResultList();
    }
}
