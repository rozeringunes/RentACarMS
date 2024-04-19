package com.turkcell.rentacar.customerService.business.dto.request.contact;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateContactRequest {
    @NotNull
    @Size(min = 15 ,max = 30)
    private String email;
    private String homePhone;
    @NotNull
    @Size(min = 10,max = 10)
    private String mobilePhone;
    private String fax;
    @NotNull
    private int customerId;
}
