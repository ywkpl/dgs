package com.dotest.dsg.fetcher;

import com.blazebit.persistence.view.CorrelationBuilder;
import com.blazebit.persistence.view.CorrelationProvider;
import com.dotest.dsg.entity.Company;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompanyCorrelationProvider implements CorrelationProvider {
    @Override
    public void applyCorrelation(CorrelationBuilder builder, String correlationExpression) {
        log.info("builder:{},expression: {}", builder, correlationExpression);

        final String alias = builder.getCorrelationAlias();
        builder.correlate(Company.class)
                .on(alias + ".id")
                .inExpressions(correlationExpression)
                .end();
//
//        // 参数 1: 目标实体类
//        // 参数 2: 别名
//        // 参数 3: 关联条件 (将实体的 companyId 与 Company 实体的 id 匹配)
//        correlationBuilder.correlate(Company.class)
//                .on(s).eqExpression("companyId")
//                .end();
//        correlationBuilder.correlate(Company.class, "company")
//                .on("company.id").eqExpression("companyId") // 这里的 companyId 是父实体的属性
//                .end();
    }
}
