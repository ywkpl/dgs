package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import com.dotest.dsg.entity.BankInfo;

@EntityView(BankInfo.class)
//@GraphQLName("BankInfo")
public interface BankInfoView {
    @IdMapping
    public Long getId();

    public Boolean getEnable();

    public String getTel();

    public String getAddr();

    public String getName();

    public String getBranchCode();

    public String getCode();

    @Mapping("CONCAT(" +
            "COALESCE(CONCAT(code, '-'), ''), " +
            "COALESCE(CONCAT(branchCode, ' '), ''), " +
            "COALESCE(name, ''))")
    public String getBankInfoName();
}
