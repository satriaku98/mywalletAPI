package com.example.mywallet.Service;

import com.example.mywallet.Entity.Customer;

public interface CustomerService {
    public Customer registerNewCostumer(Customer costumer);
    public void deleteCostumerByPhoneNumber(String phoneNumber);
}
