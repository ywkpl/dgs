package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Dept;

@EntityView(Dept.class)
public interface DeptSimpleView {
    @IdMapping
    Long getId();

    String getAddr();

    String getCode();

    String getName();
}