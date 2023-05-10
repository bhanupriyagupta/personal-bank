package com.example.personalbankingservices.Controller;

import com.example.personalbankingservices.Entity.Customer;
import com.example.personalbankingservices.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Optional<Customer> getCustomerById(@PathVariable Integer id){
        return customerService.getCustomeById(id);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public void addCustomer(@RequestBody List<Customer> list){
        customerService.addCustomer(list);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.updateCustomer(id, customer);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
    }

}
