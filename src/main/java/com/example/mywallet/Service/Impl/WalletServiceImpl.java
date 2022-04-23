package com.example.mywallet.Service.Impl;

import com.example.mywallet.Entity.Wallet;
import com.example.mywallet.Repository.CustomerRepository;
import com.example.mywallet.Service.WalletService;
import com.example.mywallet.Repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletRepository walletRepository;

    @Override
    public Wallet registerNewWallet(Wallet wallet){
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet topUp(String id, Integer topup){
        Wallet wallet = walletRepository.findById(id).get();
        wallet.setBalance(wallet.getBalance() + topup);
        return walletRepository.save(wallet);
    }

    @Override
    public Wallet checkBalance(String id){
        return walletRepository.getById(id);
    }

    @Override
    public Wallet findById(String id) {
        return walletRepository.getById(id);
    }

}
