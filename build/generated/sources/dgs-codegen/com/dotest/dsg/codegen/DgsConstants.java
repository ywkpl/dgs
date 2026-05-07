package com.dotest.dsg.codegen;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static final String MUTATION_TYPE = "Mutation";

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String Shows = "shows";

    public static final String BankInfos = "bankInfos";

    public static final String BankInfo = "bankInfo";

    public static final String SysCodes = "sysCodes";

    public static final String SysCode = "sysCode";

    public static final String BankAccounts = "bankAccounts";

    public static final String BankAccountPage = "bankAccountPage";

    public static final String BankAccount = "bankAccount";

    public static final String WorkCodes = "workCodes";

    public static final String DoIt = "doIt";

    public static class SHOWS_INPUT_ARGUMENT {
      public static final String TitleFilter = "titleFilter";
    }

    public static class BANKINFOS_INPUT_ARGUMENT {
      public static final String Query = "query";
    }

    public static class BANKINFO_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class SYSCODES_INPUT_ARGUMENT {
      public static final String Query = "query";
    }

    public static class SYSCODE_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class BANKACCOUNTS_INPUT_ARGUMENT {
      public static final String Query = "query";
    }

    public static class BANKACCOUNTPAGE_INPUT_ARGUMENT {
      public static final String Query = "query";
    }

    public static class BANKACCOUNT_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class WORKCODES_INPUT_ARGUMENT {
      public static final String Query = "query";
    }

    public static class DOIT_INPUT_ARGUMENT {
      public static final String Page = "page";

      public static final String Size = "size";
    }
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String DeleteBankAccount = "deleteBankAccount";

    public static final String UpdateBankInfo = "updateBankInfo";

    public static final String CreateBankInfo = "createBankInfo";

    public static class DELETEBANKACCOUNT_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class UPDATEBANKINFO_INPUT_ARGUMENT {
      public static final String Input = "input";
    }

    public static class CREATEBANKINFO_INPUT_ARGUMENT {
      public static final String Input = "input";
    }
  }

  public static class BANKACCOUNTPAGED {
    public static final String TYPE_NAME = "BankAccountPaged";

    public static final String Content = "content";

    public static final String TotalElements = "totalElements";

    public static final String TotalPages = "totalPages";

    public static final String PageNumber = "pageNumber";
  }

  public static class TESTPAGE {
    public static final String TYPE_NAME = "TestPage";

    public static final String Content = "content";

    public static final String TotalElements = "totalElements";

    public static final String TotalPages = "totalPages";

    public static final String PageNumber = "pageNumber";
  }

  public static class SHOW {
    public static final String TYPE_NAME = "Show";

    public static final String Title = "title";

    public static final String ReleaseYear = "releaseYear";
  }

  public static class UPDATEBANKINFO {
    public static final String TYPE_NAME = "UpdateBankInfo";

    public static final String Id = "id";

    public static final String Addr = "addr";

    public static final String Name = "name";

    public static final String BranchCode = "branchCode";

    public static final String Code = "code";

    public static final String Enable = "enable";

    public static final String Tel = "tel";
  }

  public static class CREATEBANKINFO {
    public static final String TYPE_NAME = "CreateBankInfo";

    public static final String Addr = "addr";

    public static final String Name = "name";

    public static final String BranchCode = "branchCode";

    public static final String Code = "code";

    public static final String Enable = "enable";

    public static final String Tel = "tel";
  }

  public static class WORKCODEQUERY {
    public static final String TYPE_NAME = "WorkCodeQuery";

    public static final String Code = "code";

    public static final String Name = "name";

    public static final String DeptId = "deptId";

    public static final String Codes = "codes";
  }

  public static class PAGEINPUT {
    public static final String TYPE_NAME = "pageInput";

    public static final String Page = "page";

    public static final String Size = "size";
  }

  public static class BANKACCOUNTQUERY {
    public static final String TYPE_NAME = "BankAccountQuery";

    public static final String AccountName = "accountName";

    public static final String AccountNo = "accountNo";
  }

  public static class BANKACCOUNTPAGEDQUERY {
    public static final String TYPE_NAME = "BankAccountPagedQuery";

    public static final String AccountName = "accountName";

    public static final String AccountNo = "accountNo";

    public static final String Page = "page";

    public static final String Size = "size";
  }

  public static class SYSCODEQUERY {
    public static final String TYPE_NAME = "SysCodeQuery";

    public static final String Name = "name";

    public static final String Code = "code";
  }

  public static class BANKINFOQUERY {
    public static final String TYPE_NAME = "BankInfoQuery";

    public static final String Name = "name";

    public static final String Code = "code";
  }
}
