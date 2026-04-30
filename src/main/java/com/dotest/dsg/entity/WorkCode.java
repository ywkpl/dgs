/**
 * @author: ywk
 * @Email: ywkpl@hotmail.com
 * @Description:
 */
package com.dotest.dsg.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WorkCode")
public class WorkCode extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
     * 證照屬性
     */
    @Formula("(SELECT GROUP_CONCAT(s.Name) FROM WorkCode_License w, SysCode s WHERE s.isDeleted=0 AND s.id = w.Code_LicenseType AND w.WorkCode_Id = id AND w.isDeleted = 0)")
    private String codeLicenseType;
    /**
     * 證照項目
     */
    @Formula("(SELECT GROUP_CONCAT(s.LicenseName) FROM WorkCode_License w, LicenseType s WHERE s.isDeleted=0 AND s.id = w.LicenseType_Id AND w.WorkCode_Id = id AND w.isDeleted = 0)")
    private String licenseTypeId;
    /**
     * 服務人員編號
     */
    @Column(length = 20, name = "Code")
    private String code;
    /**
     * 名稱
     */
    @Column(length = 20, name = "Name")
    private String name;
    /**
     * 部門
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Dept_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Dept deptId;
    /**
     * 員工
     */
    @Column(name = "Employee_Id")
    private Long employeeId;
    /**
     * 隸屬廠商
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Supplier_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Supplier supplierId;
    /**
     * 啟用日期
     */
    @Column(name = "StartDate")
    private ZonedDateTime startDate;
    /**
     * 停用日期
     */
    @Column(name = "EndDate")
    private ZonedDateTime endDate;
    /**
     * 職稱
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_JobTitle", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeJobTitle;
    /**
     * 休假類別設定
     */
    @Column(name = "OffDutySetting_Id")
    private Long offDutySettingId;
    /**
     * 分機
     */
    @Column(length = 20, name = "Ext")
    private String ext;
    /**
     * 通訊電話
     */
    @Column(length = 20, name = "Tel")
    private String tel;
    /**
     * 行動電話
     */
    @Column(length = 20, name = "Mobile")
    private String mobile;
    /**
     * 地址
     */
    @Column(length = 100, name = "Addr")
    private String addr;
    /**
     * 性別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_Gender", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeGender;
    /**
     * 緊急連絡人
     */
    @Column(length = 20, name = "EmerContact")
    private String emerContact;
    /**
     * 緊急連絡人關係
     */
    @Column(length = 20, name = "EmerRelationship")
    private String emerRelationship;
    /**
     * 緊急連絡人電話
     */
    @Column(length = 20, name = "EmerTel")
    private String emerTel;
    /**
     * 身份證字號
     */
    @Column(length = 20, name = "IdCardNo")
    private String idCardNo;
    /**
     * Email
     */
    @Column(length = 50, name = "Email")
    private String email;
    /**
     * 人員資料類別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_WorkCodeType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeWorkCodeType;
//    /**
//     * 客戶
//     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "Customer_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Customer customerId;
    /**
     * 備註
     */
    @Column(length = 2000, name = "Memo")
    private String memo;
    /**
     * 描述
     */
    @Column(length = 2000, name = "Description")
    private String description;
    /**
     * 稱謂
     */
    @Column(length = 20, name = "Heading")
    private String heading;
    /**
     * 縣市
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region cityRegionId;
    /**
     * 行政區
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region townRegionId;
    /**
     * 生日
     */
    @Column(name = "Bday")
    private ZonedDateTime bday;
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
     * 外包人員否
     */
    @Column(name = "OutSource")
    private Boolean outSource;
    /**
     * 外包單位備註
     */
    @Column(length = 2000, name = "OutSourceMemo")
    private String outSourceMemo;
    /**
     * 公司編號
     */
    @Column(name = "Company_Id")
    private Long companyId;
    /**
     * 集團編號
     */
    @Column(name = "TenantId")
    private Long tenantId;
    /**
     * 照片上傳ID
     */
    @Column(name = "File_Id")
    private Long fileId;
    /**
     * 聯絡窗口類別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_ContactType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeContactType;
    /**
     * 血型
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_BloodType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeBloodType;
    /**
     * 案場
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Building_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Building buildingId;
    /**
     * 通知事項類別
     */
//    @Convert(converter = JsonLongListConverter.class)
    @Column(name = "Code_NoticeType", columnDefinition = "json")
//    @Convert(converter = TestListConverter.class)
//    @JdbcTypeCode(SqlTypes.JSON)
    private List<Long> codeNoticeType;
    /**
     * 代理人
     */
    @Column(name = "substituteWorkCode_Id")
    private Long substituteWorkCodeId;
    /**
     * 在職狀態
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_WorkStatus", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeWorkStatus;
    /**
     * 內勤否
     */
    @Column(name = "IsBackOffice")
    private Boolean isBackOffice;
    /**
     * 第三方照片
     */
    @Column(name = "ThirdFile_Id")
    private Long thirdFileId;
}