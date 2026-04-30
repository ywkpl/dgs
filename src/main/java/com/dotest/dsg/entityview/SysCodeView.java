package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import com.dotest.dsg.entity.SysCode;

@EntityView(SysCode.class)
public interface SysCodeView {
    @IdMapping
    public Long getId();
    public String getCode();
    public String getName();
    public Boolean getIsDefault();
    public Integer getOrd();
    public Integer getRank();
    @Mapping("pid")
    public SysCodeSimpleView getPid();
    public Integer getMaxRank();
    public Long getCompanyId();
    public Long getTenantId();
    public Boolean getIsSys();
    public String getMemo();
    public Boolean getIsDisable();
    @Mapping("codeSysCodeType")
    public SysCodeSimpleView getCodeSysCodeType();
}
