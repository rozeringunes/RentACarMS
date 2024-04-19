package com.turkcell.rentacar.customerService.business.dto.request.address;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAddressRequest {
    @NotNull
    @Size(min=2,max=30)
    private String city;
    @NotNull
    @Size(min=2,max=30)
    private String street;
    @NotNull
    @Size(min=2,max=30)
    private String flatNumber;
    @NotNull
    @Size(min=2,max=30)
    private String addressDescription;
    @NotNull
    private int customerId;
}
