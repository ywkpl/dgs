/**
 * @author: ywk
 * @Email: ywkpl@hotmail.com
 * @Description:
 */
package com.dotest.dsg.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Company")
@EqualsAndHashCode(callSuper = true, exclude = {"buildings"})
@ToString(callSuper = true, exclude = {"buildings"})
public class Company extends FullAudited implements Serializable {
    /**
     * EMAIL
     */
    @Column(length = 50, name = "Email")
    private String email;
    /**
     * 聯絡電話
     */
    @Column(length = 20, name = "ContactTel")
    private String contactTel;
    /**
     * 聯絡人職稱
     */
    @Column(length = 20, name = "ContactJobTitle")
    private String contactJobTitle;
    /**
     * 聯絡人
     */
    @Column(length = 20, name = "Contact")
    private String contact;
    /**
     * 傳真
     */
    @Column(length = 20, name = "Fax")
    private String fax;
    /**
     * 電話
     */
    @Column(length = 20, name = "Tel")
    private String tel;
    /**
     * 地址
     */
    @Column(length = 200, name = "Addr")
    private String addr;
    /**
     * 行政區
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region townRegionId;
    /**
     * 郵遞區號
     */
    @Column(length = 10, name = "ZipCode")
    private String zipCode;
    /**
     * 縣市
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region cityRegionId;
    /**
     * 統一編號
     */
    @Column(length = 20, name = "GuiNo")
    private String guiNo;
    /**
     * 全銜
     */
    @Column(length = 50, name = "FullName")
    private String fullName;
    /**
     * 簡稱
     */
    @Column(length = 20, name = "ShortName")
    private String shortName;
    /**
     * 編號
     */
    @Column(length = 20, name = "Code")
    private String code;
    /**
     * 網址
     */
    @Column(length = 200, name = "Website")
    private String website;
    /**
     * 備註
     */
    @Column(length = 1000, name = "Memo")
    private String memo;
    /**
     * 平台名稱
     */
    @Column(length = 50, name = "PlatformName")
    private String platformName;
//    /**
//     * 集團編號
//     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TenantId", foreignKey = @ForeignKey(name = "FK_Company_TenantId"))
//    private Tenant tenantId;
    /**
     * APP URL
     */
    @Column(length = 200, name = "AppUrl")
    private String appUrl;
    /**
     * 範本公司
     */
    @Column(name = "IsTemplate")
    private Boolean isTemplate;
    /**
     * 物管APPUrl
     */
    @Column(length = 1000, name = "AppUrl1")
    private String appUrl1;
    /**
     * 首頁樣式
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_HomeStyle", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeHomeStyle;
    /**
     * 公司
     */
    @OneToMany(mappedBy = "companyId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Building> buildings = new HashSet<>();
    /**
     * 網頁色系
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_WebColor", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeWebColor;
    /**
     * 有前台網站
     */
    @Column(name = "IsWebsite")
    private Boolean isWebsite;
    /**
     * 有物件查詢
     */
    @Column(name = "IsEstateCaseQuery")
    private Boolean isEstateCaseQuery;
    /**
     * 網站色碼
     */
    @Column(length = 10, name = "WebColorCode")
    private String webColorCode;
    /**
     * 定期變更密碼週期
     */
    @Column(name = "RegularPwdMonth")
    private Integer regularPwdMonth;
    /**
     * 密碼不重複次數
     */
    @Column(name = "PwdNoRepeat")
    private Integer pwdNoRepeat;
    /**
     * 語言
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_Lang", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeLang;

}