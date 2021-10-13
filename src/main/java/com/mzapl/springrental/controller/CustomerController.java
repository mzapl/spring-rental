package com.mzapl.springrental.controller;

import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("all")
    ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }

    @PostMapping("add")
    void add(@RequestBody Customer customer){
        customerService.add(customer);
    }
}
