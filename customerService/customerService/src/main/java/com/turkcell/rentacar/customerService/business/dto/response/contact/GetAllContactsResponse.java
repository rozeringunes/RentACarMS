package com.turkcell.rentacar.customerService.business.dto.response.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class GetAllContactsResponse {
    private String email;
    private String homePhone;
    private String mobilePhone;
    private String fax;
}
