package com.turkcell.rentacar.customerService.api.controller;

import com.turkcell.rentacar.customerService.business.abstracts.AddressService;
import com.turkcell.rentacar.customerService.business.dto.request.address.CreateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.request.address.UpdateAddressRequest;
import com.turkcell.rentacar.customerService.business.dto.response.address.CreatedAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetAllAddressesResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.GetByIdAddressResponse;
import com.turkcell.rentacar.customerService.business.dto.response.address.UpdatedAddressResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/addresses")
public class AddressesController {
    private final AddressService addressService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedAddressResponse add(@Valid @RequestBody CreateAddressRequest createAddressRequest) {
        return this.addressService.add(createAddressRequest);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdatedAddressResponse update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest) {
        return this.addressService.update(updateAddressRequest);
    }
    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllAddressesResponse> getAll() {
        return this.addressService.getAll();
    }

    @GetMapping("/getById")
    @ResponseStatus(HttpStatus.OK)
    public GetByIdAddressResponse getById(@PathVariable int id) {
        return this.addressService.getById(id);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.addressService.delete(id);
    }

}
