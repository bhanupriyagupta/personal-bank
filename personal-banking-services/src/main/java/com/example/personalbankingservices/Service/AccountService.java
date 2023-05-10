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

    public String transaction(Integer sourceId, Integer destId, Double withdrawAmount){
        Optional<Account> sourceAccountOpt = accountRepository.findById(sourceId);
        Optional<Account> destAccountOpt = accountRepository.findById(destId);

        Account sourceAccount = null;

        if(sourceAccountOpt.isPresent()){
            sourceAccount = sourceAccountOpt.get();
        }
        else{
            return "Invalid Source Account ID";
        }

        Account destAccount = null;

        if(destAccountOpt.isPresent()){
            destAccount = destAccountOpt.get();
        }
        else{
            return "Invalid Destination Account ID";
        }

        Double sourceBalance = sourceAccount.getBalance();
        Double destBalance = destAccount.getBalance();

        if(sourceBalance >= withdrawAmount){
           destBalance = destBalance + withdrawAmount;
           sourceBalance = sourceBalance - withdrawAmount;

           sourceAccount.setBalance(sourceBalance);
           destAccount.setBalance(destBalance);

           accountRepository.save(sourceAccount);
            accountRepository.save(destAccount);
        }
        else {
            return "source account does not have required balance";
        }

        return "transaction successful";
    }

}
