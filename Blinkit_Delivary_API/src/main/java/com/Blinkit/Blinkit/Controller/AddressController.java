package com.Blinkit.Blinkit.Controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.AddressDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Exception.BadRequestException;
import com.Blinkit.Blinkit.Exception.ResourceNotFoundException;

import com.Blinkit.Blinkit.Service.AddressService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class AddressController {

	private AddressService addressservice;

	public AddressController(AddressService addressservice) {
		this.addressservice = addressservice;
	}

	@PostMapping("/addaddress")
	public ResponseEntity<Address> addaddress(@Valid @RequestBody Address address) throws BadRequestException {
		if(!(address.getPincode()<=6)) {
			throw new BadRequestException("Pincode is 6 laters please enter valid pincode.........");
		}
		if (address.getCity() == null || address.getCity().isBlank()) {
			throw new BadRequestException("Please enter the city...");
		}
		if (address.getDistrict() == null || address.getDistrict().isBlank()) {
			throw new BadRequestException("Please enter the District");
		}
		if (address.getState() == null || address.getState().isBlank()) {
			throw new BadRequestException("Please Enter the District");
		}

		if (address.getUser() == null || address.getUser().getUserid() <= 0) {
			throw new BadRequestException("User ID must be provided");
		}

		
		return addressservice.addaddress(address);
	}

	@GetMapping("/getaddress")
	public ResponseEntity<List<AddressDto>> getaddress() {
		return addressservice.getaddress();
	}

	@GetMapping("/getbyaddressid/{addressid}")
	public ResponseEntity<AddressDto> getbypincode(@PathVariable("addressid") int addressid) throws Exception {
		if(addressid<=0) {
			throw new ResourceNotFoundException("please enter the valid pincode");
		}
		return addressservice.getbyaddressid(addressid);
	}
}
