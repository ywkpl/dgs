package com.dotest.dsg.utils;

import com.dotest.dsg.entity.FullAudited;
import jakarta.persistence.PrePersist;

public class SnowflakeIdListener {
    @PrePersist
    public void prePersist(FullAudited entity) {
        if (entity.getId() == null) {
            entity.setId(SnowflakeIdGenerator.nextId());
        }
    }
}
