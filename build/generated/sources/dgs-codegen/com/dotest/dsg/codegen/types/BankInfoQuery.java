package com.dotest.dsg.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class BankInfoQuery {
  private String name;

  private String code;

  public BankInfoQuery() {
  }

  public BankInfoQuery(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "BankInfoQuery{name='" + name + "', code='" + code + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    BankInfoQuery that = (BankInfoQuery) o;
    return Objects.equals(name, that.name) &&
        Objects.equals(code, that.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, code);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String name;

    private String code;

    public BankInfoQuery build() {
      BankInfoQuery result = new BankInfoQuery();
      result.name = this.name;
      result.code = this.code;
      return result;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }
  }
}
