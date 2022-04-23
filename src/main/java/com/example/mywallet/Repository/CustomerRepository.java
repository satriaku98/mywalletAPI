package com.example.mywallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.mywallet.Entity.Customer;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, String> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Customer c WHERE c.phoneNumber = :phoneNumber")
    public void deleteByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}
