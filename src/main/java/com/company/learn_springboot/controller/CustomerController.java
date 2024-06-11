package com.company.learn_springboot.controller;

import com.company.learn_springboot.exception.MyBadRequestException;
import com.company.learn_springboot.exception.MyResourceNotFoundException;
import com.company.learn_springboot.model.MyResponse;
import com.company.learn_springboot.model.Customer;
import com.company.learn_springboot.service.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private customerService customerService;

    @RequestMapping(value = "/customer", produces = "application/json", method = RequestMethod.POST)
    public ResponseEntity<MyResponse> createUser(@RequestBody Customer customer) throws MyBadRequestException {
        MyResponse response;
        if(customer.isValid()) {
            customerService.saveCustomer(customer);
            response = new MyResponse("User object saved successfully", 0, "success");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        response = new MyResponse("First name of last name is missing", 9101, "fail");
        throw new MyBadRequestException(response);
    }

    @RequestMapping(value = "/customers", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<?> getAllCustomers() throws MyResourceNotFoundException {
        MyResponse response = new MyResponse("Users are not found", 9100, "fail");
        List<Customer> customers = customerService.getAllCustomers();
        if(customers == null || customers.isEmpty()) throw new MyResourceNotFoundException(response);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @RequestMapping(value = "/customer/{id}", produces = "application/json", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable int id) throws MyResourceNotFoundException {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomerById(@PathVariable int id) throws MyResourceNotFoundException {
        MyResponse response;
        customerService.deleteCustomer(id);
        response = new MyResponse("User object deleted successfully", 0, "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", produces = "application/json", method = RequestMethod.PUT)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws MyResourceNotFoundException {
        MyResponse response;
        Customer deleteObj = customerService.getCustomer(customer.getId());
        if(deleteObj != null) {
            customerService.deleteCustomer(deleteObj.getId());
        }
        customerService.saveCustomer(customer);
        response = new MyResponse("User object updated successfully", 0, "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/customer", produces = "application/json", method = RequestMethod.PATCH)
    public ResponseEntity<?> patchCustomer(@RequestBody Customer customer) throws MyBadRequestException, MyResourceNotFoundException {
        MyResponse response;
        Customer existingObj = customerService.getCustomer(customer.getId());

        if(existingObj != null) {
            existingObj.setFirstName(customer.getFirstName() != null ? customer.getFirstName() : existingObj.getFirstName());
            existingObj.setLastName(customer.getLastName() != null ? customer.getLastName() : existingObj.getLastName());
            existingObj.setAge(customer.getAge() != 0 ? customer.getAge() : existingObj.getAge());
            existingObj.setCity(customer.getCity() != null ? customer.getCity() : existingObj.getCity());
            existingObj.setPinCode(customer.getPinCode() != 0 ? customer.getPinCode() : existingObj.getPinCode());
            existingObj.setId(customer.getId() != 0 ? customer.getId() : existingObj.getId());

            response = new MyResponse("User object updated successfully", 0, "success");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }
        response = new MyResponse("Bad Request", 9105, "fail");
        throw new MyBadRequestException(response);
    }

}
