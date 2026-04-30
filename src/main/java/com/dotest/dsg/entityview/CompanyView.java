package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Company;

import java.util.Date;
import java.util.Set;

@EntityView(Company.class)
public interface CompanyView {
    @IdMapping
    Long getId();

    Date getCreationTime();

    Long getCreatorUserId();

    Date getLastModificationTime();

    Long getLastModifierUserId();

    Boolean isIsDeleted();

    Long getDeleterUserId();

    Date getDeletionTime();

    String getEmail();

    String getContactTel();

    String getContactJobTitle();

    String getContact();

    String getFax();

    String getTel();

    String getAddr();

    RegionSimpleView getTownRegionId();

    String getZipCode();

    RegionSimpleView getCityRegionId();

    String getGuiNo();

    String getFullName();

    String getShortName();

    String getCode();

    String getWebsite();

    String getMemo();

    String getPlatformName();

    String getAppUrl();

    Boolean isIsTemplate();

    String getAppUrl1();

    SysCodeSimpleView getCodeHomeStyle();

    Set<BuildingView> getBuildings();

    SysCodeSimpleView getCodeWebColor();

    Boolean isIsWebsite();

    Boolean isIsEstateCaseQuery();

    String getWebColorCode();

    Integer getRegularPwdMonth();

    Integer getPwdNoRepeat();

    SysCodeSimpleView getCodeLang();
}