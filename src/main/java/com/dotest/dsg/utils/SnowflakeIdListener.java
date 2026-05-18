package com.dotest.dsg.utils;

import com.dotest.dsg.entity.FullAudited;
import jakarta.annotation.Resource;
import jakarta.persistence.PrePersist;
import me.ahoo.cosid.provider.DefaultIdGeneratorProvider;
import me.ahoo.cosid.provider.IdGeneratorProvider;
import me.ahoo.cosid.snowflake.SnowflakeId;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;

public class SnowflakeIdListener {
    /// 方式1: 注入SnowflakeId
//    private final SnowflakeId snowflakeId;
//
//    public SnowflakeIdListener(@Qualifier("__share__SnowflakeId") @Lazy SnowflakeId snowflakeId) {
//        this.snowflakeId = snowflakeId;
//    }

    @PrePersist
    public void prePersist(FullAudited entity) {
        if (entity.getId() == null) {
//            entity.setId(snowflakeId.generate());
            /// 方式2: 使用默认的IdGeneratorProvider
            entity.setId(DefaultIdGeneratorProvider.INSTANCE.getShare().generate());
        }
    }
}
