package com.turkcell.rentacar.customerService.business.abstracts;

import com.turkcell.rentacar.customerService.business.dto.request.address.CreateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.request.address.UpdateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.response.address.CreatedAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetAllAddressesResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetByIdAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.UpdatedAddressResponse;

import java.util.List;

public interface AddressService {
    CreatedAddressResponse add(CreateAddressRequest createAddressRequest);
    UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest);
    List<GetAllAddressesResponse> getAll();
    GetByIdAddressResponse getById(int id);
    void delete(int id);
}
