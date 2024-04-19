package com.turkcell.rentacar.customerService.entities.concretes;

import com.turkcell.rentacar.customerService.core.entities.BaseEntity;
import com.turkcell.rentacar.customerService.entities.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.pqc.legacy.math.linearalgebra.PolynomialRingGF2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="customers")
public class Customer extends BaseEntity<Integer> {
    @Column(name="first_name")
    private String firstName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="last_name")
    private String lastName;


    @Column(name="birth_date")
    private LocalDate birthdate;

    @Column(name="gender")
    private Gender gender;

    @Column(name="mother_name")
    private String motherName;

    @Column(name="father_name")
    private String fatherName;

    @Column(name="nationality_number")
    private String nationalityNumber;

    @OneToMany(mappedBy = "customer")
    private Set<Address> addresses;

    @OneToOne (mappedBy = "customer")
    private Contact contacts;


}
