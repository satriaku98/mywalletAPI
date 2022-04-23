package com.example.mywallet.Controller;
import com.example.mywallet.Constant.ApiURLConstant;
import com.example.mywallet.Entity.Customer;
import com.example.mywallet.Service.CustomerService;
import com.example.mywallet.Util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.mywallet.Constant.ResponseMassage;

@RestController
@RequiredArgsConstructor
@RequestMapping(ApiURLConstant.CUSTOMER)
public class CustomerController {
    @Autowired
    CustomerService costumerService;

    @PostMapping
    public ResponseEntity<Response<Customer>> registerNewCostumer(@RequestBody Customer costumer){
        Response<Customer> response = new Response<>();
        String message = String.format(ResponseMassage.DATA_INSERTED, "Customer");
        response.setMessage(message);
        response.setData(costumerService.registerNewCostumer(costumer));
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping
    public void deleteCostumerByPhoneNumber(@RequestParam String phoneNumber){
        costumerService.deleteCostumerByPhoneNumber(phoneNumber);
    }

}
