package com.mzapl.springrental.service;

import com.mzapl.springrental.model.Archetype;
import com.mzapl.springrental.model.Customer;
import com.mzapl.springrental.model.Rental;
import com.mzapl.springrental.model.Unit;
import com.mzapl.springrental.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Optional<Customer> find(Long id){
        return customerRepository.findById(id);
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public void addRental(Rental rental){
        Optional<Customer> optionalCustomer = find(rental.getCustomer().getId());
        if(optionalCustomer.isPresent()){
            optionalCustomer.get().getRentals().add(rental);
        }
    }
}
