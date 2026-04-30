package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Supplier;

@EntityView(Supplier.class)
public interface SupplierSimpleView {
    @IdMapping
    Long getId();

    String getCode();

    String getName();

    String getFullName();

    String getAddr();
    SysCodeView getCodeSupplierType();
    RegionView getCityRegionId();
    RegionView getTownRegionId();
}