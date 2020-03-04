package com.collegesystem.accountsvc.controller;

import com.collegesystem.accountsvc.dto.AccountDto;
import com.collegesystem.accountsvc.model.Staff;
import com.collegesystem.accountsvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("/create")
    public String createAccount(@RequestBody AccountDto accountDto){
        System.out.println("调用账户模块的createAccount方法来注册");
        System.out.println(accountDto.getEmail());

        System.out.println("查询");
        List<Staff> list = this.accountService.getStaffs();
        System.out.println(list);

        return "success";
    }
    @RequestMapping("/get_account")
    public String getAccounts(){
        System.out.println("查询");
        List<Staff> list = this.accountService.getStaffs();
        System.out.println(list);
        return "success";
    }
}
