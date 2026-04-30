package com.dotest.dsg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IRepositoryBase<TEntity>
        extends JpaRepository<TEntity, Long>, JpaSpecificationExecutor<TEntity> {
    /**
     * 已在RepositoryBaseImpl中實現
     * @param idList 編號列表
     * @param userId 刪除用戶
     */
//    void batchSoftDelete(List<Long> idList, Long userId);

    /**
     * 批次插入，不查詢
     * @param entities 實體對象
     */
//    List<TEntity> batchInsert(List<TEntity> entities);
}
