package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.TestPage;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class DoItDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "doIt"
  )
  public TestPage getDoIt(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
