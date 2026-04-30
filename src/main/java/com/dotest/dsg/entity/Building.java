/**
* @author: ywk
* @Email: ywkpl@hotmail.com
* @Description: 
*/
package com.dotest.dsg.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Building")

public class Building extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
    * 集團編號
    */    @Column(name = "TenantId")
    private Long tenantId;
    /**
    * 檔案上傳
    */
    @Column(name = "File_Id")
    private Long fileId;
    /**
    * 資料維護部門
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Dept_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Dept deptId;
    /**
    * 備註
    */
    @Column(length = 2000, name = "Memo")
    private String memo;
    /**
    * 傳真
    */
    @Column(length = 20, name = "Fax")
    private String fax;
    /**
    * 門牌
    */
    @Column(length = 100, name = "Addr")
    private String addr;
    /**
    * 電話
    */
    @Column(length = 50, name = "Tel")
    private String tel;
    /**
    * 行政區
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region townRegionId;
    /**
    * 縣市
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region cityRegionId;
    /**
    * 房屋類型
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_HouseType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeHouseType;
    /**
    * 案場名稱
    */
    @Column(length = 50, name = "FullName")
    private String fullName;
    /**
    * 案場簡稱
    */
    @Column(length = 20, name = "ShortName")
    private String shortName;
    /**
    * 案場編號
    */
    @Column(length = 20, name = "Code")
    private String code;
    /**
    * 公司編號
    */
    @Column(name = "Company_Id")
    private Long companyId;
//    /**
//    * 業主
//    */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ownerCustomer_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Customer ownerCustomerId;
    /**
     * 經度
     */
    @Column(name = "Longitude")
    @Digits( integer = 20, fraction = 15)
    private BigDecimal longitude;
    /**
     * 緯度
     */
    @Column(name = "Latitude")
    @Digits( integer = 20, fraction = 15)
    private BigDecimal latitude;
    /**
     * 使用狀況
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_UseRent", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeUseRent;
    /**
     * 承攬類別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_BuildingService", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeBuildingService;
    /**
     * 管理群組
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_ManagementGroup", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeManagementGroup;
    /**
     * 總戶數
     */
    @Formula("(select count(*) from House H where H.Building_Id=Id and H.isDeleted=0)")
    private Integer houseCount;
    /**
     * 車位數
     */
    @Formula("(select count(*) from ParkingSpace ps where ps.Building_Id=Id and ps.isDeleted=0)")
    private Integer parkingSpaceCount;
    /**
     * 聯絡人
     */
    @Column(length = 20, name = "Contact")
    private String contact;
    /**
     * 案場外觀圖檔
     */
    @Column(name = "File_Id2")
    private Long fileId2;
    /**
     * 街景網址
     */
    @Column(length = 1000, name = "StreetViewUrl")
    private String streetViewUrl;
    /**
     * 業主簽核單位
     */
    @Column(length = 30, name = "CustomerReviewer")
    private String customerReviewer;
//    /**
//     * 本科分攤單位ID
//     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ownershareCustomer_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private Customer ownershareCustomerId;
    /**
     * 停用日期
     */
    @Column(name = "StopDate")
    private ZonedDateTime stopDate;
    /**
     * Email
     */
    @Column(length = 200, name = "Email")
    private String email;
    /**
     * 收款依戶分析
     */
    @Column(name = "IsHouseChargeItem")
    private Boolean isHouseChargeItem;
    /**
     * 大樓級別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_BuildingLevel", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeBuildingLevel;
//    /**
//     * 網頁報修範圍
//     */
//    @Column(name = "Code_WebInform", columnDefinition = "json")
//    private List<Long> codeWebInform;
    /**
     * 網頁報修檢查規則
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_WebInformCheck", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeWebInformCheck;
    /**
     * 網頁報修提示語
     */
    @Column(length = 2000, name = "WebInformMemo")
    private String webInformMemo;
    /**
     * 公開
     */
    @Column(name = "IsPublic")
    private Boolean isPublic;
    /**
     * 前綴
     */
    @Column(length = 2, name = "Prefix")
    private String prefix;
    /**
     * 薪資成本類別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_SalaryCostType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeSalaryCostType;
    /**
     * 第三方戶號名稱範本
     */
    @Column(length = 200, name = "ThirdHouseTemplate")
    private String thirdHouseTemplate;
    /**
     * 第三方戶號排序
     */
    @Column(length = 200, name = "ThirdHouseSort")
    private String thirdHouseSort;
}