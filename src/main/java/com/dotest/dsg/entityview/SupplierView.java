package com.dotest.dsg.entityview;

import com.blazebit.persistence.view.CreatableEntityView;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.dotest.dsg.entity.Supplier;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Date;

@EntityView(Supplier.class)
@CreatableEntityView
public interface SupplierView extends SupplierSimpleView {
    @IdMapping
    Long getId();

    void setId(Long id);

    Date getCreationTime();

    void setCreationTime(Date creationTime);

    Long getCreatorUserId();

    void setCreatorUserId(Long creatorUserId);

    Date getLastModificationTime();

    void setLastModificationTime(Date lastModificationTime);

    Long getLastModifierUserId();

    void setLastModifierUserId(Long lastModifierUserId);

    Boolean isIsDeleted();

    void setIsDeleted(Boolean isDeleted);

    Long getDeleterUserId();

    void setDeleterUserId(Long deleterUserId);

    Date getDeletionTime();

    void setDeletionTime(Date deletionTime);

    Long getCompanyId();

    void setCompanyId(Long companyId);

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getFullName();

    void setFullName(String fullName);

    SysCodeView getCodeSupplierType();

    void setCodeSupplierType(SysCodeView codeSupplierType);

    SysCodeView getCodeSupplierType2();

    void setCodeSupplierType2(SysCodeView codeSupplierType2);

    String getGuiNo();

    void setGuiNo(String guiNo);

    String getChief();

    void setChief(String chief);

    String getIdCardNo();

    void setIdCardNo(String idCardNo);

    RegionView getCityRegionId();

    void setCityRegionId(RegionView cityRegionId);

    String getAddr();

    void setAddr(String addr);

    RegionView getTownRegionId();

    void setTownRegionId(RegionView townRegionId);

    Boolean isIsAffiliated();

    void setIsAffiliated(Boolean isAffiliated);

    Integer getPayMonth();

    void setPayMonth(Integer payMonth);

    SysCodeView getCodeFeeBelong();

    void setCodeFeeBelong(SysCodeView codeFeeBelong);

    Boolean isNoInsuranceFee();

    void setNoInsuranceFee(Boolean noInsuranceFee);

    String getUrl();

    void setUrl(String url);

    ZonedDateTime getStopDate();

    void setStopDate(ZonedDateTime stopDate);

    String getStopReason();

    void setStopReason(String stopReason);

    String getMemo();

    void setMemo(String memo);

    String getLaborSafetyCode();

    void setLaborSafetyCode(String laborSafetyCode);

    String getTel();

    void setTel(String tel);

    String getFax();

    void setFax(String fax);

    String getEmail();

    void setEmail(String email);

    String getContact();

    void setContact(String contact);

    String getExt();

    void setExt(String ext);

    String getMobile();

    void setMobile(String mobile);

    SysCodeView getCodeHeadOffice();

    void setCodeHeadOffice(SysCodeView codeHeadOffice);

    SupplierSimpleView getPid();

    void setPid(SupplierSimpleView pid);

    BankInfoView getBankInfoId();

    void setBankInfoId(BankInfoView bankInfoId);

    String getAccountName();

    void setAccountName(String accountName);

    String getAccountNo();

    void setAccountNo(String accountNo);

    String getIntroducer();

    void setIntroducer(String introducer);

    String getReferrer();

    void setReferrer(String referrer);

    BigDecimal getCapital();

    void setCapital(BigDecimal capital);

    Date getOpeningDate();

    void setOpeningDate(Date openingDate);

    Boolean isIsInvoice();

    void setIsInvoice(Boolean isInvoice);

    String getInvoiceAddr();

    void setInvoiceAddr(String invoiceAddr);

    String getInvoiceTel();

    void setInvoiceTel(String invoiceTel);

    String getBusinessItem();

    void setBusinessItem(String businessItem);

    SysCodeView getCodeSupplierOrg();

    void setCodeSupplierOrg(SysCodeView codeSupplierOrg);

    String getReviewOpinion();

    void setReviewOpinion(String reviewOpinion);

    SysCodeView getCodePerson();

    void setCodePerson(SysCodeView codePerson);

    SysCodeView getCodeManagementGroup();

    void setCodeManagementGroup(SysCodeView codeManagementGroup);

    SysCodeView getCodeAppSupplierType();

    void setCodeAppSupplierType(SysCodeView codeAppSupplierType);

    Boolean isIsRequest();

    void setIsRequest(Boolean isRequest);

    Long getTenantId();

    void setTenantId(Long tenantId);

    ZonedDateTime getStopEndDate();

    void setStopEndDate(ZonedDateTime stopEndDate);

    String getOfficialNo();

    void setOfficialNo(String officialNo);

    String getCourt();

    void setCourt(String court);

    Boolean isIsTask();

    void setIsTask(Boolean isTask);

    Long getThirdFileId();

    void setThirdFileId(Long thirdFileId);
}