/**
 * @author: ywk
 * @Email: ywkpl@hotmail.com
 * @Description:
 */
package com.dotest.dsg.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SysCode")
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class SysCode extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
     * 代碼
     */
    @Column(length = 100)
    private String code;
    /**
     * 描述
     */
    @Column(length = 100)
    private String name;
    /**
     * 預設
     */
    private Boolean isDefault;
    /**
     * 排序
     */
    private Integer ord;

    /**
     * 層級
     */
    private Integer rank;

    /**
     * 父階
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pid", foreignKey = @ForeignKey(name = "FK_sysCode_pid"))
    private SysCode pid;
    /**
     * 代碼最大層級限制
     */
    @Column(name = "maxRank")
    private Integer maxRank;
    /**
     * 公司
     */
    private Long companyId;
    /**
     * 集團
     */
    private Long tenantId;
    /**
     * 系統
     */
    @Column(name = "IsSys")
    private Boolean isSys;
    /**
     * 備註
     */
    @Column(length = 2000, name = "Memo")
    private String memo;
    /**
     * 停用
     */
    @Column(name = "IsDisable")
    private Boolean isDisable;
    /**
     * 代碼類別
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Code_SysCodeType", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private SysCode codeSysCodeType;
}