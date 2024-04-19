package com.turkcell.rentacar.customerService.business.abstracts;

import com.turkcell.rentacar.customerService.business.dto.request.customer.CreateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.request.customer.UpdateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.response.customer.CreatedCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetAllCustomersResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetByIdCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.UpdatedCustomerResponse;

import java.util.List;

public interface CustomerService {
    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest);
    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest);
    List<GetAllCustomersResponse>  getAll();
    GetByIdCustomerResponse getById(int id);
    void delete(int id);
}
