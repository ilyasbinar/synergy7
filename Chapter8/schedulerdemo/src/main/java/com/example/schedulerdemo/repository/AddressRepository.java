package com.example.schedulerdemo.repository;

import com.example.schedulerdemo.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
