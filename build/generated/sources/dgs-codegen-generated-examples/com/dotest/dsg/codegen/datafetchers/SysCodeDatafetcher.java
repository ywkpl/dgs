package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.SysCodeView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class SysCodeDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "sysCode"
  )
  public SysCodeView getSysCode(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
