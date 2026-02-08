package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.AddressDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Repository.AddressRepository;
import com.Blinkit.Blinkit.Service.AddressService;

@RestController
@CrossOrigin(allowedHeaders="*")
public class AddressController {

	private AddressService addressservice;
	
	public AddressController(AddressService addressservice) {
		this.addressservice=addressservice;
	}
	
	@PostMapping("/addaddress")
	public Address addaddress(@RequestBody Address address) {
		return addressservice.addaddress(address);
	}
	
	@GetMapping("/getaddress")
	public List<AddressDto> getaddress(){
		return addressservice.getaddress();
	}
}
