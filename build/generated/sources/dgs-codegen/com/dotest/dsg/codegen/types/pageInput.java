package com.dotest.dsg.codegen.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class pageInput {
  private Integer page = 1;

  private Integer size = 10;

  public pageInput() {
  }

  public pageInput(Integer page, Integer size) {
    this.page = page;
    this.size = size;
  }

  public Integer getPage() {
    return page;
  }

  public void setPage(Integer page) {
    this.page = page;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  @Override
  public String toString() {
    return "pageInput{page='" + page + "', size='" + size + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    pageInput that = (pageInput) o;
    return Objects.equals(page, that.page) &&
        Objects.equals(size, that.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(page, size);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer page = 1;

    private Integer size = 10;

    public pageInput build() {
      pageInput result = new pageInput();
      result.page = this.page;
      result.size = this.size;
      return result;
    }

    public Builder page(Integer page) {
      this.page = page;
      return this;
    }

    public Builder size(Integer size) {
      this.size = size;
      return this;
    }
  }
}
