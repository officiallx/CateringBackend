package org.obnoxious.controllers;

import org.obnoxious.Service.AddressService;
import org.obnoxious.entities.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="https://cateringwebsite.herokuapp.com", allowedHeaders="*")
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }

    @GetMapping("/address/{addressId}")
    public Optional<Address> getAddress(@PathVariable("addressId") Long addressId){
        return addressService.getAddress(addressId);
    }

    @DeleteMapping("/address/{addressId}")
    public void deleteAddress(@PathVariable Long addressId){
        addressService.deleteAddress(addressId);
    }

    @PutMapping("/address/{addressId}")
    public void updateAddress(@RequestBody Address address, @PathVariable Long addressId){
        addressService.updateAddress(address);
    }

    @PostMapping("/address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }
}

