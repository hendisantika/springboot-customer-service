package com.hendisantika.springbootcustomerservice.controller;

import com.hendisantika.springbootcustomerservice.repository.AccountRepository;
import com.hendisantika.springbootcustomerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
}
