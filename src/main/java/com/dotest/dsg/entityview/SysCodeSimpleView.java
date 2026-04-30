package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;

import com.dotest.dsg.entity.SysCode;

@EntityView(SysCode.class)
public interface SysCodeSimpleView {
    @IdMapping
    public Long getId();
    public String getCode();
    public String getName();
}
