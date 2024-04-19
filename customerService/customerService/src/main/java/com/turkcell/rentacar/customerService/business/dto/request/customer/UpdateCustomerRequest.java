package com.turkcell.rentacar.customerService.business.dto.request.customer;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {
    @NotNull
    @Size(min=2,max=30)
    private String firstName;
    @Size(min=2,max=30)
    private String middleName;
    @NotNull
    @Size(min=2,max=30)
    private String lastName;
    @NotNull
    private LocalDate birthDate;
    @NotNull
    private String gender;
    @Size(min=2,max=30)
    private String fatherName;
    @Size(min=2,max=30)
    private String motherName;
    @NotNull
    @Size(min=2,max=30,message = "Nationality ID must be 11.")
    private String nationalityNumber;
}
