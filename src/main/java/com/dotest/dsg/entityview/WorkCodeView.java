package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.*;
import com.dotest.dsg.entity.WorkCode;
import com.dotest.dsg.fetcher.CompanyCorrelationProvider;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@EntityView(WorkCode.class)
public interface WorkCodeView {
    @IdMapping
    Long getId();

    Date getCreationTime();

    Long getCreatorUserId();

    Date getLastModificationTime();

    Long getLastModifierUserId();

    Boolean isIsDeleted();

    Long getDeleterUserId();

    Date getDeletionTime();

    String getCode();

    String getName();

    DeptSimpleView getDeptId();

    Long getEmployeeId();

    SupplierSimpleView getSupplierId();

    ZonedDateTime getStartDate();

    ZonedDateTime getEndDate();

    SysCodeSimpleView getCodeJobTitle();

    Long getOffDutySettingId();

    String getExt();

    String getTel();

    String getMobile();

    String getAddr();

    SysCodeSimpleView getCodeGender();

    String getEmerContact();

    String getEmerRelationship();

    String getEmerTel();

    String getIdCardNo();

    String getEmail();

    SysCodeSimpleView getCodeWorkCodeType();

    String getMemo();

    String getDescription();

    String getHeading();

    RegionSimpleView getCityRegionId();

    RegionSimpleView getTownRegionId();

    ZonedDateTime getBday();

    BankInfoView getBankInfoId();

    String getAccountName();

    String getAccountNo();

    Boolean isOutSource();

    String getOutSourceMemo();

    @MappingCorrelated(
            correlationBasis = "companyId",
            correlator = CompanyCorrelationProvider.class,
            fetch = FetchStrategy.JOIN
    )
    CompanyView getCompanyId();
//    Long getCompanyId();

    Long getTenantId();

    Long getFileId();

    SysCodeSimpleView getCodeContactType();

    SysCodeSimpleView getCodeBloodType();

    BuildingView getBuildingId();

    @MappingSingular
    List<Long> getCodeNoticeType();

    Long getSubstituteWorkCodeId();

    SysCodeSimpleView getCodeWorkStatus();

    Boolean isIsBackOffice();

    Long getThirdFileId();
}