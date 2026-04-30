package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.CollectionMapping;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import com.dotest.dsg.entity.Building;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@EntityView(Building.class)
public interface BuildingView {
    @IdMapping
    Long getId();

    Date getCreationTime();

    Long getCreatorUserId();

    Date getLastModificationTime();

    Long getLastModifierUserId();

    Boolean isIsDeleted();

    Long getDeleterUserId();

    Date getDeletionTime();

    Long getTenantId();

    Long getFileId();

    DeptView getDeptId();

    String getMemo();

    String getFax();

    String getAddr();

    String getTel();

    RegionView getTownRegionId();

    RegionView getCityRegionId();

    SysCodeView getCodeHouseType();

    String getFullName();

    String getShortName();

    String getCode();

    Long getCompanyId();

    BigDecimal getLongitude();

    BigDecimal getLatitude();

    SysCodeView getCodeUseRent();

    SysCodeView getCodeBuildingService();

    SysCodeView getCodeManagementGroup();

    String getContact();

    Long getFileId2();

    String getStreetViewUrl();

    String getCustomerReviewer();

    ZonedDateTime getStopDate();

    String getEmail();

    Boolean isIsHouseChargeItem();

    SysCodeView getCodeBuildingLevel();

//    @Mapping("codeWebInform")
//    Collection<Long> getCodeWebInform();

    SysCodeView getCodeWebInformCheck();

    String getWebInformMemo();

    Boolean isIsPublic();

    String getPrefix();

    SysCodeView getCodeSalaryCostType();

    String getThirdHouseTemplate();

    String getThirdHouseSort();
}