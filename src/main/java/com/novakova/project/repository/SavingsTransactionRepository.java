package com.novakova.project.repository;

import com.novakova.project.model.SavingsTransaction;
import com.novakova.project.model.security.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SavingsTransactionRepository extends CrudRepository<SavingsTransaction, Integer> {
    List<SavingsTransaction> findAll();
}
