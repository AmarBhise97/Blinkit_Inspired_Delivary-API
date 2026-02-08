package com.Blinkit.Blinkit.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.AddressDto;
import com.Blinkit.Blinkit.DTO.Order3;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Repository.AddressRepository;

@Service
public class AddressService {
	
	private AddressRepository addressrepo;
	
	public AddressService(AddressRepository addressrepo) {
		this .addressrepo =addressrepo;
	}
	
	public Address addaddress(Address address) {
		return addressrepo.save(address);
	}
	
	public List<AddressDto> getaddress(){
		return addressrepo.findAll().stream()
				.map((address)->{
					AddressDto add = new AddressDto();
					
					add.setPincode(address.getPincode());
					add.setCity(address.getCity());
					add.setDistrict(address.getDistrict());
					add.setState(address.getState());
					add.setUserid(address.getUser().getUserid());
					add.setUsername(address.getUser().getUsername());
				List<Order3> order3=address.getOrder().stream()
						.map((odd)->{
							Order3 odd3 = new Order3();
							odd3.setProductid(odd.getProductid());
							odd3.setProductname(odd.getPoductname());
							odd3.setProductprice(odd.getProductprice());
							
							
							
							return odd3;
						})
						.collect(Collectors.toList());
				
				add.setOrder(order3);
					return add;
				})
				.collect(Collectors.toList());
		
	}

}
