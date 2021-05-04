package com.novakova.project.repository;

import com.novakova.project.model.PrimaryTransaction;
import com.novakova.project.model.security.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrimaryTransactionRepository extends CrudRepository<PrimaryTransaction, Integer> {
    List<PrimaryTransaction> findAll();
}
