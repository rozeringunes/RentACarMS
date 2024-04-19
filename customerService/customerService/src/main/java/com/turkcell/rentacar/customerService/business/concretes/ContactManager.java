package com.turkcell.rentacar.customerService.business.concretes;

import com.turkcell.rentacar.customerService.business.abstracts.ContactService;
import com.turkcell.rentacar.customerService.business.dto.request.contact.CreateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.request.contact.UpdateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.response.contact.CreatedContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetAllContactsResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetByIdContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.UpdatedContactResponse;
import com.turkcell.rentacar.customerService.business.rules.ContactBusinessRules;
import com.turkcell.rentacar.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.customerService.dataAccess.ContactRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactManager implements ContactService {
    private ContactRepository contactRepository;
    private ModelMapperService modelMapperService;
    private ContactBusinessRules contactBusinessRules;

    @Override
    public CreatedContactResponse add(CreateContactRequest createContactRequest) {
       this.contactBusinessRules.isCustomerExist(createContactRequest);
        Contact contact = this.modelMapperService.forRequest().map(createContactRequest, Contact.class);
        CreatedContactResponse createdContactResponse = this.modelMapperService.forResponse().map(this.contactRepository.save(contact), CreatedContactResponse.class);
        return createdContactResponse;
    }

    @Override
    public UpdatedContactResponse update(UpdateContactRequest updateContactRequest) {
       Contact contact=this.modelMapperService.forRequest().map(updateContactRequest,Contact.class);
        return this.modelMapperService.forResponse().map(this.contactRepository.save(contact), UpdatedContactResponse.class);
    }

    @Override
    public List<GetAllContactsResponse> getAll() {
        List<Contact>contacts=this.contactRepository.findAll();
        List<GetAllContactsResponse>getAllContactsResponses=contacts.stream().map(contact ->this.modelMapperService.forResponse().map(contact,GetAllContactsResponse.class)).toList();
        return getAllContactsResponses;
    }

    @Override
    public GetByIdContactResponse getById(int id) {
        Optional<Contact> contact=this.contactRepository.findById(id);
        return this.modelMapperService.forResponse().map(contact, GetByIdContactResponse.class);
    }

    @Override
    public void delete(int id) {
        this.contactRepository.deleteById(id);
    }
}
