package com.Blinkit.Blinkit.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Blinkit.Blinkit.DTO.AddressDto;
import com.Blinkit.Blinkit.DTO.Order3;
import com.Blinkit.Blinkit.DTO.OrderDto;
import com.Blinkit.Blinkit.Entity.Address;
import com.Blinkit.Blinkit.Exception.ResourceNotFoundException;
import com.Blinkit.Blinkit.Repository.AddressRepository;

@Service
public class AddressService {
	
	private AddressRepository addressrepo;
	
	public AddressService(AddressRepository addressrepo) {
		this .addressrepo =addressrepo;
	}
	
	public ResponseEntity<Address> addaddress(Address address) {
		return new ResponseEntity<Address>(addressrepo.save(address),HttpStatus.CREATED);
	}
	public ResponseEntity<AddressDto> getbyaddressid(int pincode) throws Exception {
		return addressrepo.findById(pincode).map((pin)->{
			AddressDto add = new AddressDto();
			add.setAddressid(pin.getAddressid());
			add.setPincode(pin.getPincode());
			add.setCity(pin.getCity());
			add.setDistrict(pin.getDistrict());
			add.setState(pin.getState());
			add.setUserid(pin.getUser().getUserid());
			add.setUsername(pin.getUser().getUsername());

			return new ResponseEntity<AddressDto>(add,HttpStatus.FOUND);
		})  .orElseThrow(() -> new ResourceNotFoundException("addressid not found    .....! "));
	}
	
	
	
	public ResponseEntity<List<AddressDto>> getaddress() {

	    List<AddressDto> list = addressrepo.findAll().stream()
	            .map(address -> {
	                AddressDto add = new AddressDto();

	                add.setPincode(address.getPincode());
	                add.setAddressid(address.getAddressid());
	                add.setCity(address.getCity());
	                add.setDistrict(address.getDistrict());
	                add.setState(address.getState());
	                add.setUserid(address.getUser().getUserid());
	                add.setUsername(address.getUser().getUsername());

	                List<Order3> order = Optional.ofNullable(address.getOrder())
	                        .orElse(Collections.emptyList())
	                        .stream()
	                        .map(order3 -> {
	                            Order3 order1 = new Order3();
	                            order1.setProductid(order3.getProductid());
	                            order1.setProductname(order3.getPoductname());
	                            order1.setProductprice(order3.getProductprice());
	                            return order1;
	                        })
	                        .collect(Collectors.toList());

	                add.setOrder(order);
	                return add;
	            })
	            .collect(Collectors.toList());

	    return new ResponseEntity<>(list, HttpStatus.OK);
	}
//	public ResponseEntity<List<AddressDto>> getaddress(){
//		return addressrepo.findAll().stream()
//				.map((address)->{
//					AddressDto add = new AddressDto();
//					
//					add.setPincode(address.getPincode());
//					add.setCity(address.getCity());
//					add.setDistrict(address.getDistrict());
//					add.setState(address.getState());
//					add.setUserid(address.getUser().getUserid());
//					add.setUsername(address.getUser().getUsername());
//					List<Order3> order = Optional.ofNullable(address.getOrder())
//					        .orElse(Collections.emptyList())
//					        .stream()
//					        .map(order3 -> {
//					            Order3 order1 = new Order3();
//					            order1.setProductid(order3.getProductid());
//					            order1.setProductname(order3.getPoductname());
//					            order1.setProductprice(order3.getProductprice());
//					            return order1;
//					        })
//					        .collect(Collectors.toList());
//				
//				add.setOrder(order);
//					return new ResponseEntity<AddressDto>(add,HttpStatus.FOUND);
//				})
//				.collect(Collectors.toList());
//		
//	}

}
