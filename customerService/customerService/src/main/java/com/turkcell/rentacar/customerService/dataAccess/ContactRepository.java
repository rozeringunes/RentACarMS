package com.turkcell.rentacar.customerService.dataAccess;

import com.turkcell.rentacar.customerService.entities.concretes.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact,Integer> {
    Optional<Contact> findByCustomerId(int id);

}
