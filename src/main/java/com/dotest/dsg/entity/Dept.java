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

import java.io.Serializable;
import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "Dept")
public class Dept extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
    * 地址
    */
    @Column(length = 100, name = "Addr")
    private String addr;
    /**
    * 縣市
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region cityRegionId;
    /**
    * 部門代號
    */
    @Column(length = 20, name = "Code")
    private String code;
    /**
    * 營業屬性
    */
    @Column(name = "Code_DeptBusinessType")
    private Long codeDeptBusinessType;
    /**
    * 部門類別
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_DeptType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeDeptType;
    /**
    * 損益屬性
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_IncomeStatement", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeIncomeStatement;
    /**
    * 公司編號
    */
    @Column(name = "CompanyId")
    private Long companyId;
    /**
    * Email
    */
    @Column(length = 50, name = "Email")
    private String email;
    /**
    * 傳真
    */
    @Column(length = 20, name = "Fax")
    private String fax;
    /**
    * 備註
    */
    @Column(length = 1000, name = "Memo")
    private String memo;
    /**
    * 部門名稱
    */
    @Column(length = 20, name = "Name")
    private String name;
    /**
    * 組織ID
    */
    @Column(name = "Org_Id")
    private Long orgId;
    /**
    * 上階部門
    */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Pid", foreignKey = @ForeignKey(name = "FK_Dept_pid"))
    private Dept pid;
    /**
    * 停用日期
    */
    @Column(name = "StopDate")
    private Date stopDate;
    /**
    * 電話
    */
    @Column(length = 20, name = "Tel")
    private String tel;
    /**
    * 集團編號
    */
    @Column(name = "TenantId")
    private Long tenantId;
    /**
    * 行政區
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "townRegion_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Region townRegionId;
    /**
    * 階層
    */
    @Column(name = "Rank")
    private Integer rank;
    /**
     * 編號前綴
     */
    @Column(length = 5, name = "Prefix")
    private String prefix;
    /**
     * 預設公司轉帳帳戶
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BankAccount_Id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private BankAccount bankAccountId;
}