package com.example.personalbankingservices.Service;

import com.example.personalbankingservices.Entity.Account;
import com.example.personalbankingservices.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAccountDetails(){
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public Optional<Account> getAccountDetailsWithId(Integer id){
        Optional<Account> account = accountRepository.findById(id);
        return account;
    }

    public void addAccountDetails(List<Account> account) {
        accountRepository.saveAll(account);
    }

    public void deleteAccount(Integer id){
        accountRepository.deleteById(id);
    }

    public void updateAccount(Integer id, Account account) {
        accountRepository.save(account);
    }

}
