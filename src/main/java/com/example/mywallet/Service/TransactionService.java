package com.example.mywallet.Service;

import com.example.mywallet.Entity.Transaction;

import java.util.List;

public interface TransactionService {
    public Transaction paymentTransaction(Transaction transaction);
    public Transaction transferTransaction(Transaction transaction);
    public List<Transaction> listTransactionByWalletId(String walletId);
}
