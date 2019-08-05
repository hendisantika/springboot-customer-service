package com.hendisantika.springbootcustomerservice.controller;

import com.hendisantika.springbootcustomerservice.domain.Account;
import com.hendisantika.springbootcustomerservice.exception.ResourceNotFoundException;
import com.hendisantika.springbootcustomerservice.repository.AccountRepository;
import com.hendisantika.springbootcustomerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-customer-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-05
 * Time: 20:17
 */
@RestController
public class AccountController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping(value = "/customers/{customerId}/accounts")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Account save(@PathVariable Integer customerId, @RequestBody Account account) {
        return customerRepository.findById(customerId).map(customer -> {
            account.setCustomer(customer);
            return accountRepository.save(account);

        }).orElseThrow(() -> new ResourceNotFoundException("Customer [customerId=" + customerId + "] can't be found"));
    }

    @GetMapping(value = "/customers/{customerId}/accounts")
    public Page<Account> allData(@PathVariable Integer customerId, Pageable pageable) {
        return accountRepository.findByCustomerCustomerId(customerId, pageable);
    }

    @DeleteMapping(value = "/customers/{customerId}/accounts/{accountId}")
    public ResponseEntity<?> deleteAccount(@PathVariable Integer customerId, @PathVariable Integer accountId) {
        if (!customerRepository.existsById(customerId)) {
            throw new ResourceNotFoundException("Customer [customerId=" + customerId + "] can't be found");
        }

        return accountRepository.findById(accountId).map(account -> {
            accountRepository.delete(account);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Account [accountId=" + accountId + "] can't be found"));

    }
}
