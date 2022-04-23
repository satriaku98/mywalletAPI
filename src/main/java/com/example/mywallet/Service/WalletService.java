package com.example.mywallet.Service;

import com.example.mywallet.Entity.Wallet;

public interface WalletService {
    public Wallet registerNewWallet(Wallet wallet);
    public Wallet topUp(String id, Integer topup);
    public Wallet checkBalance(String id);
    public Wallet findById(String id);
}
