package com.hendisantika.springbootcustomerservice;

import com.hendisantika.springbootcustomerservice.domain.Account;
import com.hendisantika.springbootcustomerservice.domain.Customer;
import com.hendisantika.springbootcustomerservice.repository.AccountRepository;
import com.hendisantika.springbootcustomerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class SpringbootCustomerServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCustomerServiceApplication.class, args);
    }

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(String... args) throws Exception {

        //Naruto's account
        Customer naruto = new Customer();
        naruto.setCustomerName("Uzumaki Naruto");

        //Date dob = Date.from(LocalDate.of(1980, 03, 16).atStartOfDay(ZoneId.systemDefault()).toInstant());

        naruto.setDateofBirth(LocalDate.of(1980, 03, 16));
        naruto.setPhoneNumber("+610452623758");
        naruto = customerRepository.save(naruto);

        Account sasuke = new Account();
        sasuke.setAccountNumber(10881061);
        sasuke.setBalance(8000.00);
        //Date openingDate = Date.from(LocalDate.of(2016, 05, 16).atStartOfDay(ZoneId.systemDefault()).toInstant());
        sasuke.setOpeningDate(LocalDate.of(2016, 05, 16));
        sasuke.setCustomer(naruto);
        sasuke.setAccountName("Uchiha Sasuke");

        accountRepository.save(sasuke);


        Account sakura = new Account();
        sakura.setAccountNumber(10881069);
        sakura.setBalance(12000.00);
        sakura.setOpeningDate(LocalDate.of(2016, 05, 16));
        sakura.setCustomer(naruto);
        sakura.setAccountName("Haruno Sakura");

        accountRepository.save(sakura);


        Customer madara = new Customer();
        madara.setCustomerName("Uchiha Madara");

        madara.setDateofBirth(LocalDate.of(1985, 03, 16));
        madara.setPhoneNumber("+610452623798");
        madara = customerRepository.save(madara);

        Account hyuuga = new Account();
        hyuuga.setAccountNumber(10981061);
        hyuuga.setBalance(8000.00);
        hyuuga.setOpeningDate(LocalDate.of(2016, 05, 16));
        hyuuga.setCustomer(madara);
        hyuuga.setAccountName("Hyuuga Neji");

        accountRepository.save(hyuuga);


        Account sarutobi = new Account();
        sarutobi.setAccountNumber(10881059);
        sarutobi.setBalance(12000.00);
        sarutobi.setOpeningDate(LocalDate.of(2016, 05, 16));
        sarutobi.setCustomer(madara);
        sarutobi.setAccountName("Sarutobi Sandaime");

        accountRepository.save(sarutobi);
    }
}
