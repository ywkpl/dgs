package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.*;
import com.dotest.dsg.entity.BankInfo;

@EntityView(BankInfo.class)
@CreatableEntityView
@UpdatableEntityView
public interface BankInfoUpdateView {
    @IdMapping
    Long getId();
    void setId(Long id);

    Boolean getEnable();
    void setEnable(Boolean enable);

    String getTel();
    void setTel(String tel);

    String getAddr();
    void setAddr(String addr);

    String getName();
    void setName(String name);

    String getBranchCode();
    void setBranchCode(String branchCode);

    String getCode();
    void setCode(String code);

    @Mapping("CONCAT(" +
            "COALESCE(CONCAT(code, '-'), ''), " +
            "COALESCE(CONCAT(branchCode, ' '), ''), " +
            "COALESCE(name, ''))")
    String getBankInfoName();
}
