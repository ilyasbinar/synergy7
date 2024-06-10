package com.example.consumer.service;

import com.example.consumer.dto.AddressResponse;
import com.example.consumer.model.Address;
import com.example.consumer.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
 
    @Autowired
    private AddressRepo addressRepo;
 
    @Autowired
    private ModelMapper mapper;
 
    public AddressResponse findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = mapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }
 
}