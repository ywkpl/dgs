package com.dotest.dsg.codegen.client;

import com.netflix.graphql.dgs.client.codegen.BaseSubProjectionNode;

public class ShowsProjectionRoot<PARENT extends BaseSubProjectionNode<?, ?>, ROOT extends BaseSubProjectionNode<?, ?>> extends BaseSubProjectionNode<PARENT, ROOT> {
  public ShowsProjectionRoot() {
    super(null, null, java.util.Optional.of("Show"));
  }

  public ShowsProjectionRoot<PARENT, ROOT> __typename() {
    getFields().put("__typename", null);
    return this;
  }

  public ShowsProjectionRoot<PARENT, ROOT> title() {
    getFields().put("title", null);
    return this;
  }

  public ShowsProjectionRoot<PARENT, ROOT> releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
