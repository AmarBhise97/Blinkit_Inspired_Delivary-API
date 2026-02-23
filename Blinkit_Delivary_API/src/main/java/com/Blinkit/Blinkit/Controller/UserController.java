package com.Blinkit.Blinkit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blinkit.Blinkit.DTO.UserDto;
import com.Blinkit.Blinkit.Entity.User1;
import com.Blinkit.Blinkit.Exception.BadRequestException;
import com.Blinkit.Blinkit.Exception.ResourceNotFoundException;
import com.Blinkit.Blinkit.Repository.UserRepository;
import com.Blinkit.Blinkit.Service.UserService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/addalluser")
	public ResponseEntity<UserDto> adduser(@RequestBody UserDto user1) throws BadRequestException {
		if (user1.getUsername() == null || user1.getUsername().isBlank()) {
			throw new BadRequestException("userName is blank.....");
		}

		if (!(user1.getUser_number().equals("10"))) {
			throw new BadRequestException("Please enter correct number");
		}

		return userservice.adduser(user1);
	}

	@GetMapping("getbyuserid/{userid}")
	public ResponseEntity<UserDto> getbyid(@PathVariable("userid") int userid) throws Exception {
		return userservice.getbyidd(userid);

	}

	@GetMapping("/getall")
	public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(value="num")int num,@RequestParam(value="size")int size) throws BadRequestException, ResourceNotFoundException {
		List<UserDto> users = userservice.getall(num ,size); // call service
		if (users == null || users.isEmpty()) {
			throw new ResourceNotFoundException("no any user in this system");
		}
		return new ResponseEntity<>(users, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteuser(@PathVariable("id") int userid) throws Exception {
		// return userservice.deletebyid(userid);
		return ResponseEntity.ok(userservice.deletebyid(userid));
	}

}
