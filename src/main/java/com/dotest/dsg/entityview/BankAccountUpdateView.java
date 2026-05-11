package com.dotest.dsg.entityview;

import com.blazebit.persistence.integration.graphql.GraphQLName;
import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.UpdatableEntityView;
import com.dotest.dsg.entity.BankAccount;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@EntityView(BankAccount.class)
@CreatableEntityView
@UpdatableEntityView
public interface BankAccountUpdateView extends BankAccountView {
    void setAccountName(String accountName);

    void setBankInfoId(BankInfoView bankInfoId);

    void setAccountNo(String accountNo);

    void setShortName(String shortName);

    void setFileId(Long fileId);

    void setIsDefault(Boolean isDefault);

    void setIsAch(Boolean isAch);

    void setIsAchApproval(Boolean isAchApproval);

    void setBankCode(String bankCode);

    void setMemo(String memo);

    void setGuiNo(String guiNo);

    void setStopDate(ZonedDateTime stopDate);

    void setAmount20kFee(BigDecimal amount20kFee);

    void setAmount20kCode(String amount20kCode);

    void setAmount40kFee(BigDecimal amount40kFee);

    String getAmount40kCode();
    void setAmount40kCode(String amount40kCode);

    BigDecimal getAmount60kFee();
    void setAmount60kFee(BigDecimal amount60kFee);

    String getAmount60kCode();
    void setAmount60kCode(String amount60kCode);

    Integer getCodeQty();
    void setCodeQty(Integer codeQty);

    SysCodeSimpleView getCodeBankFileType();
    void setCodeBankFileType(SysCodeSimpleView codeBankFileType);

    SysCodeSimpleView getCodeTransFeePayer();
    void setCodeTransFeePayer(SysCodeSimpleView codeTransFeePayer);

    Long getCompanyId();
    void setCompanyId(Long companyId);

    Long getTenantId();
    void setTenantId(Long tenantId);

    String getOnlineBankingId();
    void setOnlineBankingId(String onlineBankingId);

    String getOnlineBankingUser();
    void setOnlineBankingUser(String onlineBankingUser);

    String getOnlineBankingPassword();
    void setOnlineBankingPassword(String onlineBankingPassword);

    Long getInvoiceUnitId();
    void setInvoiceUnitId(Long invoiceUnitId);

    SysCodeSimpleView getCodeBankFileType2();
    void setCodeBankFileType2(SysCodeSimpleView codeBankFileType2);
}
