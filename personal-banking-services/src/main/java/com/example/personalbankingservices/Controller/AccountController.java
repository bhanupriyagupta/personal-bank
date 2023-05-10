package com.example.personalbankingservices.Controller;

import com.example.personalbankingservices.Entity.Account;
import com.example.personalbankingservices.Service.AccountService;
import com.example.personalbankingservices.bean.AccTransactionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/account")
    public List<Account> getAccountDetails(){
        return accountService.getAccountDetails();
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public Optional<Account> getAccountDetailsWithId(@PathVariable Integer id){
        return accountService.getAccountDetailsWithId(id);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public void addAccountDetails(@RequestBody List<Account> account){
        accountService.addAccountDetails(account);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public void deleteAccount(@PathVariable Integer id){
        accountService.deleteAccount(id);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public void updateAccount(@PathVariable Integer id, @RequestBody Account account){
        accountService.updateAccount(id,account);
    }

    @RequestMapping(value = "/account/transaction", method = RequestMethod.POST)
    public String transaction(@RequestBody AccTransactionBean txBean){
       return accountService.transaction(txBean.getSourceAccountId(), txBean.getDestAccountId(), txBean.getAmount());
    }
}
