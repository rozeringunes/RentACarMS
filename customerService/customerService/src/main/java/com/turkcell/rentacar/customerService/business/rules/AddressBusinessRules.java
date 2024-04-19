package com.turkcell.rentacar.customerService.business.rules;

import com.turkcell.rentacar.customerService.business.dto.request.address.CreateAddressRequest;
import com.turkcell.rentacar.customerService.business.messages.AddressMessages;
import com.turkcell.rentacar.customerService.core.utilities.exception.types.BusinessException;
import com.turkcell.rentacar.customerService.dataAccess.AddressRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressBusinessRules {
    private AddressRepository addressRepository;

    public void isCustomerExist(CreateAddressRequest createAddressRequest){
        Optional<Address> address =this.addressRepository.findByCustomerId(createAddressRequest.getCustomerId());
        if (address.isEmpty()){
            throw new BusinessException(AddressMessages.CUSTOMER_DOES_NOT_EXIST);
        }
    }
}

