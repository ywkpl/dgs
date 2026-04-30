package com.dotest.dsg.repository;

import com.dotest.dsg.entity.IBaseEntity;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@Slf4j
@NoRepositoryBean
public class RepositoryBaseImpl<TEntity extends IBaseEntity> extends SimpleJpaRepository<TEntity, Long> implements IRepositoryBase<TEntity> {
    private EntityManager entityManager;
    private JpaEntityInformation<TEntity, ?> entityInformation;

    public RepositoryBaseImpl(Class<TEntity> domainClass, EntityManager em) {
        super(domainClass, em);
        this.entityManager = em;
    }

    public RepositoryBaseImpl(JpaEntityInformation<TEntity, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

//    @Override
//    public void batchSoftDelete(List<Long> idList, Long userId) {
//
//    }
//
//    @Override
//    public List<TEntity> batchInsert(List<TEntity> tEntities) {
//        return List.of();
//    }
}
