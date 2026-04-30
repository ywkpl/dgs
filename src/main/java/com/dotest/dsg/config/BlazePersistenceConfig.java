package com.dotest.dsg.config;

import com.blazebit.persistence.Criteria;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupport;
import com.blazebit.persistence.integration.graphql.GraphQLEntityViewSupportFactory;
import com.blazebit.persistence.integration.view.spring.EnableEntityViews;
import com.blazebit.persistence.spi.CriteriaBuilderConfiguration;
import com.blazebit.persistence.spring.data.repository.config.EnableBlazeRepositories;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViews;
import com.blazebit.persistence.view.spi.EntityViewConfiguration;
import com.dotest.dsg.entityview.BankAccountView;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.SysCodeSimpleView;
import com.dotest.dsg.entityview.SysCodeView;
import graphql.schema.GraphQLSchema;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@EnableBlazeRepositories(basePackages = "com.dotest.dsg.repository")
@EnableEntityViews(basePackages = "com.dotest.dsg.entityview")
public class BlazePersistenceConfig {
//    @Bean
//    public EntityViewManager entityViewManager(CriteriaBuilderFactory cbf, EntityManagerFactory emf) {
//        EntityViewConfiguration configuration = EntityViews.createDefaultConfiguration();
//
//        configuration.addEntityView(BankInfoView.class);
//        configuration.addEntityView(BankAccountView.class);
//        configuration.addEntityView(SysCodeView.class);
//        configuration.addEntityView(SysCodeSimpleView.class);
//        return configuration.createEntityViewManager(cbf);
//    }

    @Bean
    public EntityViewManager entityViewManager(CriteriaBuilderFactory cbf, EntityViewConfiguration entityViewConfiguration){
        return entityViewConfiguration.createEntityViewManager(cbf);
    }

    @Bean
    public CriteriaBuilderFactory createCriteriaBuilderFactory(EntityManagerFactory emf) {
        return Criteria.getDefault().createCriteriaBuilderFactory(emf);
    }
}