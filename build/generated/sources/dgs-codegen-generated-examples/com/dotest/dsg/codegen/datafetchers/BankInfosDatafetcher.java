package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.BankInfoView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class BankInfosDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "bankInfos"
  )
  public List<BankInfoView> getBankInfos(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
