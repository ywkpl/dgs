package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.SysCodeView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class SysCodesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "sysCodes"
  )
  public List<SysCodeView> getSysCodes(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
