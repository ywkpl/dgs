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

//    void setFileId(Long fileId);
//
//    void setIsDefault(Boolean isDefault);
//
//    void setIsAch(Boolean isAch);
//
//    void setIsAchApproval(Boolean isAchApproval);
//
//    void setBankCode(String bankCode);
//
//    void setMemo(String memo);
//
    void setGuiNo(String guiNo);

    void setStopDate(ZonedDateTime stopDate);

    void setAmount20kFee(BigDecimal amount20kFee);

    void setAmount20kCode(String amount20kCode);

    void setAmount40kFee(BigDecimal amount40kFee);
//
//    void setAmount40kCode(String amount40kCode);
//
//    void setAmount60kFee(BigDecimal amount60kFee);
//
//    void setAmount60kCode(String amount60kCode);
//
//    void setCodeQty(Integer codeQty);
//
//    void setCodeBankFileType(SysCodeSimpleView codeBankFileType);
//
//    void setCodeTransFeePayer(SysCodeSimpleView codeTransFeePayer);
//
//    void setCompanyId(Long companyId);
//
//    void setTenantId(Long tenantId);
//
//    void setOnlineBankingId(String onlineBankingId);
//
//    void setOnlineBankingUser(String onlineBankingUser);
//
//    void setOnlineBankingPassword(String onlineBankingPassword);
//
//    void setInvoiceUnitId(Long invoiceUnitId);
//
//    void setCodeBankFileType2(SysCodeSimpleView codeBankFileType2);
}
