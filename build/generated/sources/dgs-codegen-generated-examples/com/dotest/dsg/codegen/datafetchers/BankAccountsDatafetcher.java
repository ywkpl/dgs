package com.dotest.dsg.codegen.datafetchers;

import com.dotest.dsg.codegen.types.BankAccount;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;
import java.util.List;

@DgsComponent
public class BankAccountsDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "bankAccounts"
  )
  public List<BankAccount> getBankAccounts(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
