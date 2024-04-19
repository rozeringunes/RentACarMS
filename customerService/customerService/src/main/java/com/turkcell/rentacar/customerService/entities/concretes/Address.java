package com.turkcell.rentacar.customerService.entities.concretes;

import com.turkcell.rentacar.customerService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="addresses")
public class Address extends BaseEntity {
    @Column(name="city")
    private String city;

    @Column(name="street")
    private String street;

    @Column(name="flat_number")
    private String flatNumber;

    @Column(name="address_description")
    private String addressDescription;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
}
