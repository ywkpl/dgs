package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.*;
import com.dotest.dsg.entity.BankInfo;

@EntityView(BankInfo.class)
@CreatableEntityView
@UpdatableEntityView
public interface BankInfoUpdateView extends BankInfoView {
    void setId(Long id);

    void setEnable(Boolean enable);

    void setTel(String tel);

    void setAddr(String addr);

    void setName(String name);

    void setBranchCode(String branchCode);

    void setCode(String code);
}
