package com.turkcell.rentacar.customerService.business.dto.response.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdatedContactResponse {
    private int id;
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
