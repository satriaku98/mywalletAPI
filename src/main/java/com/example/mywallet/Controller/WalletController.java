package com.example.mywallet.Controller;

import com.example.mywallet.Constant.ApiURLConstant;
import com.example.mywallet.Entity.Wallet;
import com.example.mywallet.Service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiURLConstant.WALLET)
public class WalletController {
    @Autowired
    WalletService walletService;

    @PostMapping
    public Wallet registerNewWallet(@RequestBody Wallet wallet){
        return walletService.registerNewWallet(wallet);
    }
    @PutMapping
    public Wallet topUp(@RequestParam String id,@RequestParam Integer topup){
        return walletService.topUp(id,topup);
    }
    @GetMapping
    public Wallet getById(@RequestParam String id){
        return walletService.checkBalance(id);
    }
}
