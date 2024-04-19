package com.turkcell.rentacar.customerService.business.concretes;

import com.turkcell.rentacar.customerService.business.abstracts.CustomerService;
import com.turkcell.rentacar.customerService.business.dto.request.customer.CreateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.request.customer.UpdateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.response.customer.CreatedCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetAllCustomersResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.GetByIdCustomerResponse;
import com.turkcell.rentacar.customerService.business.dto.response.customer.UpdatedCustomerResponse;
import com.turkcell.rentacar.customerService.business.rules.CustomerBusinessRules;
import com.turkcell.rentacar.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.customerService.dataAccess.CustomerRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    private CustomerBusinessRules customerBusinessRules;

    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) {
        this.customerBusinessRules.nationalityNumberCanNotBeDuplicate(createCustomerRequest);
        Customer customer = this.modelMapperService.forRequest().map(createCustomerRequest, Customer.class);
        CreatedCustomerResponse createdCustomerResponse = this.modelMapperService.forResponse().map(this.customerRepository.save(customer), CreatedCustomerResponse.class);
        return createdCustomerResponse;
    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest) {
        this.customerBusinessRules.nationalityNumberCanNotBeDuplicate(updateCustomerRequest);
        Customer customer =this.modelMapperService.forRequest().map(updateCustomerRequest,Customer.class);
        return this.modelMapperService.forResponse().map(this.customerRepository.save(customer),UpdatedCustomerResponse.class);
    }

    @Override
    public List<GetAllCustomersResponse> getAll() {
        List<Customer>customers=this.customerRepository.findAll();
        return null;
    }
    @Override
    public GetByIdCustomerResponse getById(int id) {
        Optional<Customer> customer=this.customerRepository.findById(id);
        return this.modelMapperService.forResponse().map(customer,GetByIdCustomerResponse.class);
    }

    @Override
    public void delete(int id) {
        this.customerRepository.deleteById(id);

    }
}
