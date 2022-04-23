package com.example.mywallet.Service.Impl;

import com.example.mywallet.Entity.Transaction;
import com.example.mywallet.Entity.Wallet;
import com.example.mywallet.Repository.TransactionRepository;
import com.example.mywallet.Service.TransactionService;
import com.example.mywallet.Service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.mywallet.Constant.ResponseMassage;
import com.example.mywallet.Exception.BalanceNotEnoughException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    WalletService walletService;
    @Override
    public Transaction paymentTransaction(Transaction transaction){
        Wallet wallet = walletService.findById(transaction.getWallet_id());
        if (wallet.getBalance()<transaction.getAmount()){
            String message = String.format(ResponseMassage.BALANCE_NOT_ENOUGH, wallet.getUser_id());
            throw new BalanceNotEnoughException(message);
        }
        wallet.setBalance(wallet.getBalance()-transaction.getAmount());
        walletService.registerNewWallet(wallet);
        transaction.setTarget("Payment");
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction transferTransaction(Transaction transaction) {
        Wallet wallet = walletService.findById(transaction.getWallet_id());
        Wallet walletTarget = walletService.findById(transaction.getTarget());
        if (wallet.getBalance()<transaction.getAmount()){
            String message = String.format(ResponseMassage.BALANCE_NOT_ENOUGH, wallet.getUser_id());
            throw new BalanceNotEnoughException(message);
        }
        //BalanceSumberBerkurang
        wallet.setBalance(wallet.getBalance()-transaction.getAmount());
        walletService.registerNewWallet(wallet);
        //BalanceSumberBertambah
        walletTarget.setBalance(walletTarget.getBalance()+transaction.getAmount());
        walletService.registerNewWallet(walletTarget);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> listTransactionByWalletId(String walletId) {
        return transactionRepository.findByWallet_id(walletId);
    }
}
