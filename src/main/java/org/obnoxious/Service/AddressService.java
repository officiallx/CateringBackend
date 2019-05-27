package org.obnoxious.Service;

import org.obnoxious.entities.Address;
import org.obnoxious.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddress(){
        return (List<Address>) addressRepository.findAll();
    }

    public Optional<Address> getAddress(Long addressId){
        return addressRepository.findById(addressId);
    }

    public void addAddress(Address address){
        addressRepository.save(address);
    }

    public void updateAddress(Address address) {
        addressRepository.save(address);
    }

    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
