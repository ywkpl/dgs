/**
* @author: ywk
* @Email: ywkpl@hotmail.com
* @Description: 
*/
package com.dotest.dsg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BankInfo")
public class BankInfo extends FullAudited implements Serializable {
    /**
     * 啟用
     */
    @Column(name = "Enable")
    private Boolean enable;
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
     * 名稱
     */
    @Column(length = 50, name = "Name")
    private String name;
    /**
     * 分行代號
     */
    @Column(length = 20, name = "BranchCode")
    private String branchCode;
    /**
     * 總行代號
     */
    @Column(length = 20, name = "Code")
    private String code;
    /**
     * bankInfoName(code-branchCode name)
     */
    @Formula("(select CONCAT(if(ISNULL(code),'', CONCAT(code, '-')),if(ISNULL(BranchCode),'', CONCAT(BranchCode, ' ')) ,IFNULL(name, '')) from BankInfo bi where bi.id = Id)")
    private String bankInfoName;
}