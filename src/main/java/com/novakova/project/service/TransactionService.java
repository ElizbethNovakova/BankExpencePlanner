package com.novakova.project.service;

import com.novakova.project.model.PrimaryAccount;
import com.novakova.project.model.PrimaryTransaction;
import com.novakova.project.model.SavingsAccount;
import com.novakova.project.model.SavingsTransaction;

import java.util.List;

public interface TransactionService {
    List<PrimaryTransaction> findPrimaryTransactionList(String username);
    List<SavingsTransaction> findSavingsTransactionList(String username);
    void savePrimaryDepositTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
    void savePrimaryWithdrawTransaction(PrimaryTransaction primaryTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, PrimaryAccount primaryAccount, SavingsAccount savingsAccount) throws Exception;
}
