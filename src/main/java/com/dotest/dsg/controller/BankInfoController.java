package com.dotest.dsg.controller;

import com.dotest.dsg.codegen.types.*;
import com.dotest.dsg.entityview.BankInfoView;
import com.dotest.dsg.entityview.PaginatedResult;
import com.dotest.dsg.service.BankInfoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bankInfo")
public class BankInfoController {
    private final BankInfoService bankInfoService;

    public BankInfoController(BankInfoService bankInfoService) {
        this.bankInfoService = bankInfoService;
    }

    @GetMapping("/get")
    public ResponseEntity<BankInfoView> get(@Valid Long id) {
        BankInfoView bankInfo = bankInfoService.get(id, null);
        return ResponseEntity.ok(bankInfo);
    }

    @GetMapping("/getList")
    public List<BankInfoView> getList(@Valid BankInfoQuery query) {
        return bankInfoService.getList(query, null);
    }

    @GetMapping("/getPage")
    public PaginatedResult<BankInfoView> getPage(@Valid BankInfoPagedQuery query) {
        return bankInfoService.getPage(query, null);
    }

    @GetMapping("/delete")
    public Boolean delete(@Valid Long id) {
        return bankInfoService.delete(id);
    }

    @PostMapping("/create")
    public BankInfoView create(@RequestBody @Valid CreateBankInfo input) {
        return bankInfoService.create(input,null);
    }

    @PostMapping("/update")
    public BankInfoView update(@RequestBody @Valid UpdateBankInfo input) {
        return bankInfoService.update(input,null);
    }
}
