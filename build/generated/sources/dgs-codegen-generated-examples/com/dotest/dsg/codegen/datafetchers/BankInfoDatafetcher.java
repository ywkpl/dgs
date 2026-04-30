package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.BankInfoView;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class BankInfoDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "bankInfo"
  )
  public BankInfoView getBankInfo(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
