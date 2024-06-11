package com.company.learn_springboot.service;

import com.company.learn_springboot.exception.MyResourceNotFoundException;
import com.company.learn_springboot.model.Customer;
import com.company.learn_springboot.model.MyResponse;
import com.company.learn_springboot.repository.customerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class customerService {

    @Autowired
    private customerRepository customerRepository;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer getCustomer(int id) throws MyResourceNotFoundException {
        Optional<Customer> opt = customerRepository.findById(id);
        if(opt.isPresent()) {
            return opt.get();
        }
        MyResponse response = new MyResponse("NO User found", 9100, "fail");;
        throw new MyResourceNotFoundException(response);
    }

    public List<Customer> getAllCustomers() throws MyResourceNotFoundException {
        List<Customer> customers = customerRepository.findAll();
        if(!customers.isEmpty()) {
            return customers;
        }
        MyResponse response = new MyResponse("NO User found", 9100, "fail");;
        throw new MyResourceNotFoundException(response);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
