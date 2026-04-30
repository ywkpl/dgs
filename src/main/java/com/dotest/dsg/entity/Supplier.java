/**
* @author: ywk
* @Email: ywkpl@hotmail.com
* @Description: 
*/
package com.dotest.dsg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Supplier")
@EqualsAndHashCode(callSuper=false)
//@EqualsAndHashCode(callSuper = true, exclude = {"supplierContacts"})
//@ToString(callSuper = true, exclude = {"supplierContacts"})
public class Supplier extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
    * 公司編號
    */
    @Column(name = "Company_Id")
    private Long companyId;
    /**
    * 廠商編號
    */
    @Column(length = 20, name = "Code")
    private String code;
    /**
    * 廠商簡稱
    */
    @Column(nullable = false, length = 20, name = "Name")
    private String name;
    /**
    * 廠商全銜
    */
    @Column(length = 50, name = "FullName")
    private String fullName;
    /**
    * 廠商類別
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_SupplierType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeSupplierType;
    /**
    * 廠商小類
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_SupplierType2", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeSupplierType2;
    /**
    * 統一編號
    */
    @Column(length = 20, name = "GuiNo")
    private String guiNo;
    /**
    * 公司負責人
    */
    @Column(length = 20, name = "Chief")
    private String chief;
    /**
    * 身份證字號
    */
    @Column(length = 20, name = "IdCardNo")
    private String idCardNo;
    /**
    * 縣市
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region cityRegionId;
    /**
    * 地址
    */
    @Column(length = 100, name = "Addr")
    private String addr;
    /**
    * 行政區
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region townRegionId;
    /**
    * 關係企業
    */
    @Column(name = "IsAffiliated")
    private Boolean isAffiliated;
    /**
    * 付款月數
    */
    @Column(name = "PayMonth")
    private Integer payMonth;
    /**
    * 匯款手續費負擔
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_FeeBelong", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeFeeBelong;
    /**
    * 免扣補充保費
    */
    @Column(name = "NoInsuranceFee")
    private Boolean noInsuranceFee;
    /**
    * 網址
    */
    @Column(length = 100, name = "Url")
    private String url;
    /**
    * 停止配合日期
    */
    @Column(name = "StopDate")
    private ZonedDateTime stopDate;
    /**
    * 停止原因說明
    */
    @Column(length = 500, name = "StopReason")
    private String stopReason;
    /**
    * 備註
    */
    @Column(length = 1000, name = "Memo")
    private String memo;
    /**
    * 勞安組織設置核准文
    */
    @Column(length = 30, name = "LaborSafetyCode")
    private String laborSafetyCode;
    /**
    * 電話
    */
    @Column(length = 20, name = "Tel")
    private String tel;
    /**
    * 傳真
    */
    @Column(length = 20, name = "Fax")
    private String fax;
    /**
    * Email
    */
    @Column(length = 50, name = "Email")
    private String email;
    /**
    * 聯絡人姓名
    */
    @Column(length = 20, name = "Contact")
    private String contact;
    /**
    * 分機
    */
    @Column(length = 20, name = "Ext")
    private String ext;
    /**
    * 行動電話
    */
    @Column(length = 20, name = "Mobile")
    private String mobile;
    /**
    * 廠商代表公司
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_HeadOffice", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeHeadOffice;
    /**
    * 父階
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Pid", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Supplier pid;
    /**
    * 開戶銀行
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BankInfo_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BankInfo bankInfoId;
    /**
    * 戶名
    */
    @Column(length = 50, name = "AccountName")
    private String accountName;
    /**
    * 帳號
    */
    @Column(length = 50, name = "AccountNo")
    private String accountNo;
    /**
    * 介紹人
    */
    @Column(length = 20, name = "Introducer")
    private String introducer;
    /**
    * 推薦人
    */
    @Column(length = 20, name = "Referrer")
    private String referrer;
//    /**
//    * 推薦業主
//    */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ownerCustomer_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Customer ownerCustomerId;
    /**
    * 資本額
    */
    @Column(name = "Capital")
    @Digits( integer = 18, fraction = 0)
    private BigDecimal capital;
    /**
    * 開業日期
    */
    @Column(name = "OpeningDate")
    private Date openingDate;
    /**
    * 開立發票否
    */
    @Column(name = "IsInvoice")
    private Boolean isInvoice;
    /**
    * 發票地址
    */
    @Column(length = 100, name = "InvoiceAddr")
    private String invoiceAddr;
    /**
    * 發票電話
    */
    @Column(length = 20, name = "InvoiceTel")
    private String invoiceTel;
    /**
    * 營業項目
    */
    @Column(length = 100, name = "BusinessItem")
    private String businessItem;
    /**
    * 廠商組織別
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_SupplierOrg", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeSupplierOrg;
    /**
    * 調查意見
    */
    @Column(length = 1000, name = "ReviewOpinion")
    private String reviewOpinion;
    /**
    * 組織型態
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_Person", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codePerson;
    /**
    * 管理群組
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_ManagementGroup", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeManagementGroup;
    /**
     * APP廠商專區
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_AppSupplierType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeAppSupplierType;
    /**
     * 有提供備料
     */
    @Column(name = "IsRequest")
    private Boolean isRequest;
    /**
    * 集團編號
    */
    @Column(name = "TenantId")
    private Long tenantId;

//    /**
//     * 子階
//     */
//    @OneToMany(mappedBy = "supplierId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @Builder.Default
//    private Set<SupplierContact> supplierContacts = new HashSet<>();
    /**
     * 停止配合日期訖
     */
    @Column(name = "StopEndDate")
    private ZonedDateTime stopEndDate;
    /**
     * 文號
     */
    @Column(length = 50, name = "OfficialNo")
    private String officialNo;
    /**
     * 所屬法院
     */
    @Column(length = 50, name = "Court")
    private String court;
    /**
     * 任務單廠商
     */
    @Column(name = "IsTask")
    private Boolean isTask;
    /**
     * 第三方照片
     */
    @Column(name = "ThirdFile_Id")
    private Long thirdFileId;
}