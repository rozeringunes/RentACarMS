package com.turkcell.rentacar.customerService.business.concretes;

import com.turkcell.rentacar.customerService.business.abstracts.AddressService;
import com.turkcell.rentacar.customerService.business.dto.request.address.CreateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.request.address.UpdateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.response.address.CreatedAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetAllAddressesResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetByIdAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.UpdatedAddressResponse;
import com.turkcell.rentacar.customerService.business.rules.AddressBusinessRules;
import com.turkcell.rentacar.customerService.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.customerService.dataAccess.AddressRepository;
import com.turkcell.rentacar.customerService.entities.concretes.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressManager implements AddressService {
    private AddressRepository addressRepository;
    private ModelMapperService modelMapperService;
    private AddressBusinessRules addressBusinessRules;
    @Override
    public CreatedAddressResponse add(CreateAddressRequest createAddressRequest) {
        this.addressBusinessRules.isCustomerExist(createAddressRequest);
        Address address=this.modelMapperService.forRequest().map(createAddressRequest,Address.class);
        CreatedAddressResponse createdAddressResponse=this.modelMapperService.forResponse().map(this.addressRepository.save(address),CreatedAddressResponse.class);
        return createdAddressResponse;
    }
    @Override
    public UpdatedAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        Address address=this.modelMapperService.forRequest().map(updateAddressRequest,Address.class);
        return this.modelMapperService.forResponse().map(this.addressRepository.save(address), UpdatedAddressResponse.class);
    }
    @Override
    public List<GetAllAddressesResponse> getAll() {
        List<Address>addresses=this.addressRepository.findAll();
        List<GetAllAddressesResponse>getAllAddressesResponses=addresses.stream().map(address -> this.modelMapperService.forResponse().map(address, GetAllAddressesResponse.class)).toList();
        return getAllAddressesResponses;
    }
    @Override
    public GetByIdAddressResponse getById(int id) {
        Optional<Address>address=this.addressRepository.findById(id);
        return this.modelMapperService.forResponse().map(address, GetByIdAddressResponse.class);
    }
    @Override
    public void delete(int id) {
        this.addressRepository.deleteById(id);

    }
}
