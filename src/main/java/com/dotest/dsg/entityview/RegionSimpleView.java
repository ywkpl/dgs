package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Region;
import jakarta.persistence.Column;

@EntityView(Region.class)
public interface RegionSimpleView {
    @IdMapping
    Long getId();

    String getCode();

    String getFullName();

    String getName();
}
