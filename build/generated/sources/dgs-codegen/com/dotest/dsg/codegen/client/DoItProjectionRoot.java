package com.dotest.dsg.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class DoItProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public DoItProjectionRoot() {
    super(null, null, java.util.Optional.of("TestPage"));
  }

  public DoItProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public DoItProjectionRoot<PARENT, ROOT> content() {
    getFields().put("content", null);
    return this;
  }

  public DoItProjectionRoot<PARENT, ROOT> totalElements() {
    getFields().put("totalElements", null);
    return this;
  }

  public DoItProjectionRoot<PARENT, ROOT> totalPages() {
    getFields().put("totalPages", null);
    return this;
  }

  public DoItProjectionRoot<PARENT, ROOT> pageNumber() {
    getFields().put("pageNumber", null);
    return this;
  }
}
