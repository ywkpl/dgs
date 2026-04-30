package com.dotest.dsg.entityview;

import com.blazebit.persistence.integration.graphql.GraphQLName;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;
import com.dotest.dsg.entity.BankAccount;
import com.dotest.dsg.entity.BankInfo;
import com.dotest.dsg.entity.SysCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import tools.jackson.databind.annotation.JsonSerialize;
import tools.jackson.databind.ser.std.ToStringSerializer;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@EntityView(BankAccount.class)
@GraphQLName("BankAccount")
public interface BankAccountView {
    @IdMapping
    public Long getId();

    String getAccountName();

    BankInfoView getBankInfoId();

    String getAccountNo();

    String getShortName();

    Long getFileId();

    Boolean getIsDefault();

    Boolean getIsAch();

    Boolean getIsAchApproval();

    String getBankCode();

    String getMemo();

    String getGuiNo();

    ZonedDateTime getStopDate();

    BigDecimal getAmount20kFee();

    String getAmount20kCode();

    BigDecimal getAmount40kFee();

    String getAmount40kCode();

    BigDecimal getAmount60kFee();

    String getAmount60kCode();

    Integer getCodeQty();

    SysCodeSimpleView getCodeBankFileType();

    SysCodeSimpleView getCodeTransFeePayer();

    Long getCompanyId();

    Long getTenantId();

    String getOnlineBankingId();

    String getOnlineBankingUser();

    String getOnlineBankingPassword();

    Long getInvoiceUnitId();

    SysCodeSimpleView getCodeBankFileType2();
}
