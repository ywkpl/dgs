package com.dotest.dsg.entity;

import com.blazebit.persistence.view.spi.type.TypeConverter;

import java.lang.reflect.Type;
import java.util.List;

public class PassThroughListConverter implements TypeConverter<List<Long>, List<Long>> {
    @Override
    public Class<?> getUnderlyingType(Class<?> owningClass, Type declaredType) {
        return null;
    }

    @Override
    public List<Long> convertToViewType(List<Long> object) {
        return object;
    }

    @Override
    public List<Long> convertToUnderlyingType(List<Long> object) {
        return List.of();
    }
}
