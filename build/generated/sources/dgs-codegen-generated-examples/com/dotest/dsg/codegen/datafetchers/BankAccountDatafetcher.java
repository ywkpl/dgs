package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.BankAccount;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class BankAccountDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "bankAccount"
  )
  public BankAccount getBankAccount(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
