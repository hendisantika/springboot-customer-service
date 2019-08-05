package com.hendisantika.springbootcustomerservice.repository;

import com.hendisantika.springbootcustomerservice.domain.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-customer-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-05
 * Time: 20:10
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Page<Account> findByCustomerCustomerId(Integer customerId, Pageable pageable);
}