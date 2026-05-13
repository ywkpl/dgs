package com.dotest.dsg.mapper;

import com.blazebit.persistence.view.EntityViewManager;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReferenceMapper {
    @Autowired
    private EntityViewManager evm;

    public <T> T resolve(Long id, @TargetType Class<T> entityViewClass) {
        if (id != null) {
            return evm.getReference(entityViewClass,id);
        }
        return null;
    }
}
