package com.example.mywallet.Controller;

import com.example.mywallet.Constant.ApiURLConstant;
import com.example.mywallet.Entity.Transaction;
import com.example.mywallet.Entity.Wallet;
import com.example.mywallet.Service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.example.mywallet.Util.Response;
import com.example.mywallet.Constant.ResponseMassage;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiURLConstant.TRANSACTION)
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping
    public Transaction paymentTransaction(@RequestBody Transaction transaction){
        return transactionService.paymentTransaction(transaction);
    }
    @PostMapping("/transfer")
    public Transaction transferTransaction(@RequestBody Transaction transaction){
        return transactionService.transferTransaction(transaction);
    }
    @GetMapping
    public ResponseEntity<Response<List<Transaction>>>  findTransactionByWalletId(@RequestParam String wallet_id){
        Response<List<Transaction>> response = new Response<>();
        response.setData(transactionService.listTransactionByWalletId(wallet_id));
        long countData = transactionService.listTransactionByWalletId(wallet_id).stream().count();
        String message = String.format(ResponseMassage.DATA_COUNT, wallet_id,countData);
        response.setMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
