package com.turkcell.rentacar.customerService.business.dto.response.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedAddressResponse {
    private int id;
    private String customerFirstName;
    private String city;
    private String street;
    private String flatNumber;
    private String addressDescription;
}
