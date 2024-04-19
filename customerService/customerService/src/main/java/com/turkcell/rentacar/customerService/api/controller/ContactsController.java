package com.turkcell.rentacar.customerService.api.controller;

import com.turkcell.rentacar.customerService.business.abstracts.ContactService;
import com.turkcell.rentacar.customerService.business.dto.request.contact.CreateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.request.contact.UpdateContactRequest;
import com.turkcell.rentacar.customerService.business.dto.response.contact.CreatedContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetAllContactsResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.GetByIdContactResponse;
import com.turkcell.rentacar.customerService.business.dto.response.contact.UpdatedContactResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/contacts")
public class ContactsController {
    private final ContactService contactService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedContactResponse add(@Valid @RequestBody CreateContactRequest createContactRequest) {
        return this.contactService.add(createContactRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedContactResponse update(@Valid @RequestBody UpdateContactRequest updateContactRequest) {
        return this.contactService.update(updateContactRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllContactsResponse> getAll() {
        return this.contactService.getAll();
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdContactResponse getById(@PathVariable int id) {
        return this.contactService.getById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.contactService.delete(id);
    }
}