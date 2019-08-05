package com.hendisantika.springbootcustomerservice.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-customer-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 2019-08-05
 * Time: 20:07
 */
@Table(name = "CUSTOMER")
@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = -6759774343110776659L;

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID", updatable = false)
    private Integer customerId;

    @Column(name = "NAME")
    private String customerName;

    @Column(name = "DOB", nullable = true)
    private LocalDate dateofBirth;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

