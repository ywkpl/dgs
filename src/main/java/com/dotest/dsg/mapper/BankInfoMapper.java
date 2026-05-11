package com.dotest.dsg.mapper;

import com.blazebit.persistence.view.EntityViewManager;
import com.dotest.dsg.codegen.types.CreateBankInfo;
import com.dotest.dsg.codegen.types.UpdateBankInfo;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entityview.BankInfoUpdateView;
import com.dotest.dsg.entityview.BankInfoView;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class BankInfoMapper {
    @Autowired
    protected EntityViewManager evm;

    @ObjectFactory
    public <T> T create(@TargetType Class<T> clazz) {
        return evm.create(clazz);
    }

    public abstract BankInfoUpdateView toCreate(CreateBankInfo entity);

    public abstract BankInfoUpdateView toUpdate(UpdateBankInfo entity);

    public abstract void updateView(UpdateBankInfo dto, @MappingTarget BankInfoUpdateView view);

//    public abstract BankInfoUpdateView toUpdateView(UpdateBankInfo entity);
}
