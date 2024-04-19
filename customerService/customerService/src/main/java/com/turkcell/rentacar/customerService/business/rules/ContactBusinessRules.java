package com.turkcell.rentacar.customerService.business.rules;

import com.turkcell.rentacar.customerService.business.dto.request.contact.CreateContactRequest;
import com.turkcell.rentacar.customerService.business.messages.ContactMessages;
import com.turkcell.rentacar.customerService.core.utilities.exception.types.BusinessException;
import com.turkcell.rentacar.customerService.dataAccess.ContactRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Contact;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactBusinessRules {
    private ContactRepository contactRepository;

    public void isCustomerExist(CreateContactRequest createContactRequest) {
        Optional<Contact> contact = this.contactRepository.findByCustomerId(createContactRequest.getCustomerId());
        if (contact.isEmpty()) {
            throw new BusinessException(ContactMessages.CUSTOMER_DOES_NOT_EXIST);
        }
    }
}
