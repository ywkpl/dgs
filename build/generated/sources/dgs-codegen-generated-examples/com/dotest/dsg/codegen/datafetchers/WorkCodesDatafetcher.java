package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.WorkCodeView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class WorkCodesDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "workCodes"
  )
  public List<WorkCodeView> getWorkCodes(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
