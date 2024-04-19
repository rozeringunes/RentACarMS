package com.turkcell.rentacar.customerService.dataAccess;

import com.turkcell.rentacar.customerService.entities.concretes.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address,Integer> {
    Optional<Address> findByCustomerId(int id);

}
