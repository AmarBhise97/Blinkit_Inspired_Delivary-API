package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.UserDto;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Repository.UserRepository;
import com.Blinkit.Blinkit.Service.UserService;

@RestController
@CrossOrigin(allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	
	
	@PostMapping("/addalluser")
	public User1 adduser(@RequestBody User1 user1) {
		return userservice.adduser(user1);
	}
	@GetMapping("getbyuserid/{userid}")
	public User1 getbyid(@PathVariable("userid") int userid) {
		return userservice.getbyidd(userid);
		
	}
	@GetMapping("/getall")
	public List<UserDto> getuser(){
		return userservice.getall();
	}

}
