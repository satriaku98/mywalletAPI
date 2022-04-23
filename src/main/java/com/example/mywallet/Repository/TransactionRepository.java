package com.example.mywallet.Repository;

import com.example.mywallet.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, String> {
    @Query(value = "SELECT t.transaction_id , t.amount , t.target , t.user_id , t.wallet_id FROM trx_transaction t WHERE t.wallet_id = ?1", nativeQuery = true)
    public List<Transaction> findByWallet_id(@Param("wallet_id") String walletId);
}
