package com.example.mywallet.Service.Impl;
import com.example.mywallet.Service.CustomerService;
import com.example.mywallet.Repository.CustomerRepository;
import com.example.mywallet.Entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer registerNewCostumer(Customer costumer){
        return customerRepository.save(costumer);
    }

    @Override
    public void deleteCostumerByPhoneNumber(String phoneNumber){
        customerRepository.deleteByPhoneNumber(phoneNumber);
    }
}
