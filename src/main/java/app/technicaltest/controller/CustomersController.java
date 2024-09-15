package app.technicaltest.controller;


import app.technicaltest.Service.CustomerServices;
import app.technicaltest.models.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersController {
    @Autowired
    CustomerServices customerService = new CustomerServices();
    @GetMapping("/profiles")
    public List<Customers> Customer(){

        return  customerService.getCustomers();
    }
}
