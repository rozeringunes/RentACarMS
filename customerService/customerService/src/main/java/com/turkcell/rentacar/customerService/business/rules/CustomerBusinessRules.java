package com.turkcell.rentacar.customerService.business.rules;

import com.turkcell.rentacar.customerService.business.dto.request.customer.CreateCustomerRequest;
import com.turkcell.rentacar.customerService.business.dto.request.customer.UpdateCustomerRequest;
import com.turkcell.rentacar.customerService.business.messages.CustomerMessages;
import com.turkcell.rentacar.customerService.core.utilities.exception.types.BusinessException;
import com.turkcell.rentacar.customerService.dataAccess.CustomerRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerBusinessRules {
    private CustomerRepository customerRepository;
    public void nationalityNumberCanNotBeDuplicate(CreateCustomerRequest createCustomerRequest){
        Optional<Customer> customer = this.customerRepository.
                findCustomerByNationalityNumberEquals(createCustomerRequest.getNationalityNumber());
        if (customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NATIONALITY_ID_CAN_NOT_DUPLICATE);
        }
    }
    public void nationalityNumberCanNotBeDuplicate(UpdateCustomerRequest updateCustomerRequest){
        Optional<Customer> customer = this.customerRepository.
                findCustomerByNationalityNumberEquals(updateCustomerRequest.getNationalityNumber());
        if (customer.isEmpty()){
            throw new BusinessException(CustomerMessages.NATIONALITY_ID_CAN_NOT_DUPLICATE);
        }
    }

    public void isCustomerIdExist(int id){
        Optional<Customer> customer = this.customerRepository.findById(id);
        if (customer.isEmpty()){
            throw new BusinessException(CustomerMessages.CUSTOMER_DOES_NOT_EXIST);
        }
    }
}

