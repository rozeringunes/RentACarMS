package com.turkcell.rentacar.customerService.api.controller;

import com.turkcell.rentacar.customerService.business.abstracts.CustomerService;
import com.turkcell.rentacar.customerService.business.dto.request.customer.CreateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.request.customer.UpdateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.response.customer.CreatedCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetAllCustomersResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetByIdCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.UpdatedCustomerResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomersController {
    private final CustomerService customerService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) {
        return this.customerService.add(createCustomerRequest);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedCustomerResponse update(@Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return this.customerService.update(updateCustomerRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCustomersResponse> getAll() {
        return this.customerService.getAll();
    }

    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdCustomerResponse getById(@PathVariable int id) {
        return this.customerService.getById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.customerService.delete(id);
    }
}
