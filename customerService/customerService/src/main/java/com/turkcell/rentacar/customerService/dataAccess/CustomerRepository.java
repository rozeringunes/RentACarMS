package com.turkcell.rentacar.customerService.dataAccess;

import com.turkcell.rentacar.customerService.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends  JpaRepository <Customer,Integer>{
    Optional<Customer> findCustomerByNationalityNumberEquals(String nationalityNumber);

}
