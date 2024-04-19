package com.turkcell.rentacar.customerService.business.abstracts;

import com.turkcell.rentacar.customerService.business.dto.request.contact.CreateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.request.contact.UpdateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.response.contact.CreatedContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetAllContactsResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetByIdContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.UpdatedContactResponse;

import java.util.List;

public interface ContactService {
    CreatedContactResponse add(CreateContactRequest createContactRequest);
    UpdatedContactResponse update(UpdateContactRequest updateContactRequest);
    List<GetAllContactsResponse> getAll();
    GetByIdContactResponse getById(int id);
    void delete (int id);

}
