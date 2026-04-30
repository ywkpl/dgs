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

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "Region")
public class Region extends FullAudited implements Serializable, IHaveCompany, IHaveTenant {
    /**
     * 父階
     */
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "Pid", foreignKey = @ForeignKey(name = "FK_region_pid"))
    private Region pid;
    /**
     * 區域代號
     */
    @Column(length = 20, name = "Code")
    private String code;
    /**
     * 全名
     */
    @Column(length = 50, name = "FullName")
    private String fullName;
    /**
     * 簡稱
     */
    @Column(nullable = false, length = 20, name = "Name")
    private String name;
    /**
     * 層級
     */
    @Column(name = "Rank")
    private Integer rank;
    /**
     * 排序
     */
    @Column(name = "Ord")
    private Integer ord;
    /**
     * 區域天氣代碼
     */
    @Column(length = 20, name = "WeatherCode")
    private String weatherCode;
    /**
     * 緯度
     */
    @Column(name = "Latitude")
    @Digits( integer = 20, fraction = 15)
    private BigDecimal latitude;
    /**
     * 經度
     */
    @Column(name = "Longitude")
    @Digits( integer = 20, fraction = 15)
    private BigDecimal longitude;
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
}