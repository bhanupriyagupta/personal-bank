package com.example.personalbankingservices.Repository;

import com.example.personalbankingservices.Entity.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Integer> {
}
