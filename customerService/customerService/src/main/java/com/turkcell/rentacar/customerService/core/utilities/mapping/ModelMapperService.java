package com.turkcell.rentacar.customerService.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public interface ModelMapperService {
   ModelMapper forResponse();
   ModelMapper forRequest();
}
