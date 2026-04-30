package com.dotest.dsg.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class BankAccountQuery {
  private String accountName;

  private String accountNo;

  public BankAccountQuery() {
  }

  public BankAccountQuery(String accountName, String accountNo) {
    this.accountName = accountName;
    this.accountNo = accountNo;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  @Override
  public String toString() {
    return "BankAccountQuery{accountName='" + accountName + "', accountNo='" + accountNo + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankAccountQuery that = (BankAccountQuery) o;
    return Objects.equals(accountName, that.accountName) &&
        Objects.equals(accountNo, that.accountNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountName, accountNo);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String accountName;

    private String accountNo;

    public BankAccountQuery build() {
      BankAccountQuery result = new BankAccountQuery();
      result.accountName = this.accountName;
      result.accountNo = this.accountNo;
      return result;
    }

    public Builder accountName(String accountName) {
      this.accountName = accountName;
      return this;
    }

    public Builder accountNo(String accountNo) {
      this.accountNo = accountNo;
      return this;
    }
  }
}
