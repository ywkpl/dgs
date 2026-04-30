package com.dotest.dsg.codegen.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class WorkCodeQuery {
  private String code;

  private String name;

  private String deptId;

  private List<String> codes;

  public WorkCodeQuery() {
  }

  public WorkCodeQuery(String code, String name, String deptId, List<String> codes) {
    this.code = code;
    this.name = name;
    this.deptId = deptId;
    this.codes = codes;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDeptId() {
    return deptId;
  }

  public void setDeptId(String deptId) {
    this.deptId = deptId;
  }

  public List<String> getCodes() {
    return codes;
  }

  public void setCodes(List<String> codes) {
    this.codes = codes;
  }

  @Override
  public String toString() {
    return "WorkCodeQuery{code='" + code + "', name='" + name + "', deptId='" + deptId + "', codes='" + codes + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    WorkCodeQuery that = (WorkCodeQuery) o;
    return Objects.equals(code, that.code) &&
        Objects.equals(name, that.name) &&
        Objects.equals(deptId, that.deptId) &&
        Objects.equals(codes, that.codes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, deptId, codes);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String code;

    private String name;

    private String deptId;

    private List<String> codes;

    public WorkCodeQuery build() {
      WorkCodeQuery result = new WorkCodeQuery();
      result.code = this.code;
      result.name = this.name;
      result.deptId = this.deptId;
      result.codes = this.codes;
      return result;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder deptId(String deptId) {
      this.deptId = deptId;
      return this;
    }

    public Builder codes(List<String> codes) {
      this.codes = codes;
      return this;
    }
  }
}
