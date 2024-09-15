package app.technicaltest.Service;

import app.technicaltest.Interfaces.*;
import app.technicaltest.Repository.CustomerRepository;
import app.technicaltest.models.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServices implements iCustomers {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customers> getCustomers() {
        //List<Customers> customers = customerRepository.findAll();
        return customerRepository.findAll();
    }

    @Override
    public Customers findCustomer(Integer idCustomer) {
        Customers customer = customerRepository.findById(idCustomer).orElse(null);
        return customer;
    }

    @Override
    public void addCustomer(Customers customers) {

    }
}
