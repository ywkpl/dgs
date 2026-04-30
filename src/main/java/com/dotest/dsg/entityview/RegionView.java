package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Region;

import java.math.BigDecimal;
import java.util.Date;

@EntityView(Region.class)
public interface RegionView {
    @IdMapping
    Long getId();

    Date getCreationTime();

    Long getCreatorUserId();

    Date getLastModificationTime();

    Long getLastModifierUserId();

    Boolean isIsDeleted();

    Long getDeleterUserId();

    Date getDeletionTime();

    RegionSimpleView getPid();

    String getCode();

    String getFullName();

    String getName();

    Integer getRank();

    Integer getOrd();

    String getWeatherCode();

    BigDecimal getLatitude();

    BigDecimal getLongitude();

    Long getCompanyId();

    Long getTenantId();
}