/**
 * @author: ywk
 * @Email: ywkpl@hotmail.com
 * @Description: 
 */
package com.dotest.dsg.entity;

import jakarta.validation.constraints.Digits;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "BankAccount")
public class BankAccount extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
     * 戶名
     */
    @Column(length = 50, name = "AccountName")
    private String accountName;
    /**
     * 開戶銀行
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BankInfo_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BankInfo bankInfoId;
    /**
     * 帳號
     */
    @Column(length = 50, name = "AccountNo")
    private String accountNo;
    /**
     * 帳戶簡稱
     */
    @Column(length = 20, name = "ShortName")
    private String shortName;
    /**
     * 存摺影本上傳
     */
    @Column(name = "File_Id")
    private Long fileId;
    /**
     * 預設帳戶
     */
    @Column(name = "IsDefault")
    private Boolean isDefault;
    /**
     * 銀行轉帳扣款
     */
    @Column(name = "IsAch")
    private Boolean isAch;
    /**
     * 銀行審核通過
     */
    @Column(name = "IsAchApproval")
    private Boolean isAchApproval;
    /**
     * 銀行企業編號
     */
    @Column(length = 50, name = "BankCode")
    private String bankCode;
    /**
     * 備註
     */
    @Column(length = 1000, name = "Memo")
    private String memo;
    /**
     * 統一編號
     */
    @Column(length = 50, name = "GuiNo")
    private String guiNo;
    /**
     * 終止日
     */
    @Column(name = "StopDate")
    private ZonedDateTime stopDate;
    /**
     * 2萬以下手續費
     */
    @Column(name = "Amount20kFee")
    @Digits( integer = 18, fraction = 0)
    private BigDecimal amount20kFee;
    /**
     * 2萬以下手續費代碼
     */
    @Column(length = 20, name = "Amount20kCode")
    private String amount20kCode;
    /**
     * 4萬以下手續費
     */
    @Column(name = "Amount40kFee")
    @Digits( integer = 18, fraction = 0)
    private BigDecimal amount40kFee;
    /**
     * 4萬以下手續費代碼
     */
    @Column(length = 20, name = "Amount40kCode")
    private String amount40kCode;
    /**
     * 6萬以下手續費
     */
    @Column(name = "Amount60kFee")
    @Digits( integer = 18, fraction = 0)
    private BigDecimal amount60kFee;
    /**
     * 6萬以下手續費代碼
     */
    @Column(length = 20, name = "Amount60kCode")
    private String amount60kCode;
    /**
     * 繳款碼碼數
     */
    @Column(name = "CodeQty")
    private Integer codeQty;
    /**
     * 銀行回饋檔格式
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_BankFileType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeBankFileType;
    /**
     * 交易手續費負擔方
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_TransFeePayer", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeTransFeePayer;
    /**
     * 公司編號
     */
    @Column(name = "CompanyId")
    private Long companyId;
    /**
     * 集團編號
     */
    @Column(name = "TenantId")
    private Long tenantId;
    /**
     * 網銀企業戶ID
     */
    @Column(length = 20, name = "OnlineBankingId")
    private String onlineBankingId;
    /**
     * 網銀用戶代號
     */
    @Column(length = 20, name = "OnlineBankingUser")
    private String onlineBankingUser;
    /**
     * 網銀密碼
     */
    @Column(length = 20, name = "OnlineBankingPassword")
    private String onlineBankingPassword;
    /**
     * 指定稅籍編號
     */
    @Column(name = "InvoiceUnit_Id")
    private Long invoiceUnitId;
    /**
     * 銀行匯款格式
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_BankFileType2", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeBankFileType2;
}