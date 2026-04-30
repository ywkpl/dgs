package com.dotest.dsg.fetcher;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.PagedList;
import com.blazebit.persistence.PaginatedCriteriaBuilder;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.dotest.dsg.entityview.PagedResult;
import com.dotest.dsg.entityview.PaginatedResult;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaginationHelper {

    @Autowired
    private EntityViewManager evm;
    @Autowired
    private CriteriaBuilderFactory cbf;
    @Autowired
    private EntityManager em;

    public <T> PaginatedResult<T> fetchPage(Class<T> viewClass, int page, int size) {
        // 1. 创建基础查询
        CriteriaBuilder<T> cb = (CriteriaBuilder<T>) cbf.create(em, getEntityClass(viewClass));
        cb.orderBy("id", true);

        // 2. 将 Entity 转换为 Entity View (DTO)
        EntityViewSetting<T, PaginatedCriteriaBuilder<T>> setting =
                EntityViewSetting.create(viewClass, page * size, size);

        // 3. 执行分页查询 (Blaze-Persistence 核心)
        PagedList<T> pagedList = evm.applySetting(setting, cb)
                .getResultList();

        return PaginatedResult.<T>builder()
                .content(pagedList)
                .totalPages(pagedList.getTotalPages())
                .totalElements(pagedList.getMaxResults())
                .pageNumber(pagedList.getPage())
                .build();
    }

    // 内部辅助方法：根据 View 获取原始 Entity 类
    private Class<?> getEntityClass(Class<?> viewClass) {
        return evm.getMetamodel().view(viewClass).getEntityClass();
    }
}