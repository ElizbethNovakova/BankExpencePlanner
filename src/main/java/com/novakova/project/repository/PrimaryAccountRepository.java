package com.novakova.project.repository;


import com.novakova.project.model.PrimaryAccount;
import org.springframework.data.repository.CrudRepository;

public interface PrimaryAccountRepository extends CrudRepository<PrimaryAccount, Long> {
    PrimaryAccount findByAccountNumber(int accountNumber);
}
