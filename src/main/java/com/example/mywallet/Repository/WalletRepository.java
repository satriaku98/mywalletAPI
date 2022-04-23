package com.example.mywallet.Repository;

import com.example.mywallet.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WalletRepository extends JpaRepository <Wallet, String> {
//    @Modifying
//    @Transactional
    @Query("SELECT w FROM Wallet w WHERE w.id = :id")
    public Wallet getById(String id);
}
