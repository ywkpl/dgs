package com.dotest.dsg.mapper;

import com.blazebit.persistence.view.EntityViewManager;
import com.dotest.dsg.codegen.types.CreateBankAccount;
import com.dotest.dsg.entityview.BankAccountUpdateView;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public abstract class BankAccountMapper {
    @Autowired
    protected EntityViewManager evm;

    @ObjectFactory
    public <T> T create(@TargetType Class<T> clazz) {
        return evm.create(clazz);
    }

    public abstract BankAccountUpdateView toCreate(CreateBankAccount dto);
//    public abstract BankAccountUpdateView toUpdate(UpdateBankAccount dto);
}
