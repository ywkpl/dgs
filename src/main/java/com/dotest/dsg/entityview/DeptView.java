package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Dept;

import java.util.Date;

@EntityView(Dept.class)
public interface DeptView extends DeptSimpleView {
    @IdMapping
    Long getId();

    Date getCreationTime();

    Long getCreatorUserId();

    Date getLastModificationTime();

    Long getLastModifierUserId();

    Boolean isIsDeleted();

    Long getDeleterUserId();

    Date getDeletionTime();

    String getAddr();

    RegionView getCityRegionId();

    String getCode();

    Long getCodeDeptBusinessType();

    SysCodeView getCodeDeptType();

    SysCodeView getCodeIncomeStatement();

    Long getCompanyId();

    String getEmail();

    String getFax();

    String getMemo();

    String getName();

    Long getOrgId();

    DeptSimpleView getPid();

    Date getStopDate();

    String getTel();

    Long getTenantId();

    RegionView getTownRegionId();

    Integer getRank();

    String getPrefix();

    BankAccountView getBankAccountId();
}