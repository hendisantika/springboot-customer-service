package com.hendisantika.springbootcustomerservice.repository;

import com.hendisantika.springbootcustomerservice.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-customer-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-05
 * Time: 20:11
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}