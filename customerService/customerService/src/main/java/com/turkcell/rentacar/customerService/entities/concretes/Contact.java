package com.turkcell.rentacar.customerService.entities.concretes;

import com.turkcell.rentacar.customerService.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "contacts")
public class Contact extends BaseEntity {
    @Column(name="email")
    private String email;

    @Column(name="home_phone")
    private String homePhone;

    @Column(name="mobile_phone")
    private String mobilePhone;

    @Column(name="fax")
    private String fax;

    @OneToOne
    @JoinColumn(name = "customer")
    private Customer customer;

}
