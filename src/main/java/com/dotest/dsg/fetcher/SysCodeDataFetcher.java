package com.dotest.dsg.fetcher;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.codegen.types.SysCodeQuery;
import com.dotest.dsg.entity.SysCode;
import com.dotest.dsg.entityview.SysCodeView;
import com.dotest.dsg.repository.SysCodeRepository;
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
public class SysCodeDataFetcher {

    private final SysCodeRepository sysCodeRepository;
    private final CriteriaBuilderFactory cbf;
    private final EntityManager em;
    private final EntityViewManager evm;

    public SysCodeDataFetcher(SysCodeRepository sysCodeRepository, CriteriaBuilderFactory cbf, EntityManager em, EntityViewManager evm) {
        this.sysCodeRepository = sysCodeRepository;
        this.cbf = cbf;
        this.em = em;
        this.evm = evm;
    }

    @Autowired
    private GraphQLEntityViewSupport graphQLEntityViewSupport;

    @DgsQuery
    public List<SysCodeView> sysCodes(@InputArgument SysCodeQuery query, DgsDataFetchingEnvironment dfe) {
        CriteriaBuilder<SysCode> cb = cbf.create(em, SysCode.class);
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

        EntityViewSetting<SysCodeView, ?> setting = graphQLEntityViewSupport.createSetting(SysCodeView.class, dfe);

        return evm.applySetting(setting, cb)
                .getResultList();
    }

    @DgsQuery
    public SysCode sysCode(Long id) {
        return sysCodeRepository.findById(id).orElse(null);
    }
}
