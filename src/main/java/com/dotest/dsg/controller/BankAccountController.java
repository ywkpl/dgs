package com.dotest.dsg.controller;

import com.dotest.dsg.codegen.types.BankAccountPagedQuery;
import com.dotest.dsg.codegen.types.BankAccountQuery;
import com.dotest.dsg.entityview.BankAccountView;
import com.dotest.dsg.entityview.PaginatedResult;
import com.dotest.dsg.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/get")
    public ResponseEntity<BankAccountView> getBankAccount(Long id) {
        BankAccountView bankAccount = bankAccountService.get(id, null);
        return ResponseEntity.ok(bankAccount);
    }

    @GetMapping("/getList")
    public List<BankAccountView> getList(@Valid BankAccountQuery query) {
        return bankAccountService.getList(query, null);
    }

    @GetMapping("/getPage")
    public PaginatedResult<BankAccountView> getPage(@Valid BankAccountPagedQuery query) {
        return bankAccountService.getPage(query, null);
    }

    @GetMapping("/delete")
    public Boolean delete(@Valid Long id) {
        return bankAccountService.delete(id);
    }
}
