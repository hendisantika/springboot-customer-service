package com.hendisantika.springbootcustomerservice.controller;

import com.hendisantika.springbootcustomerservice.domain.Customer;
import com.hendisantika.springbootcustomerservice.exception.ResourceNotFoundException;
import com.hendisantika.springbootcustomerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-customer-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-05
 * Time: 20:20
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping(value = "/customers")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Customer save(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

    @GetMapping(value = "/customers")
    public Page<Customer> getAllData(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping(value = "/customers/{customerId}")
    public Customer findByCustomerId(@PathVariable Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId=" + customerId + "] can't be found"));
    }
}
