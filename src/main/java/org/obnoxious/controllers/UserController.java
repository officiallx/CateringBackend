package org.obnoxious.controllers;

import org.obnoxious.Service.UserService;
import org.obnoxious.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/user/{userId}")
	public User getUser(@PathVariable Long userId){
		return userService.getUser(userId);
	}

	@DeleteMapping("/user/{userId}")
	public void deleteUser(@PathVariable Long userId){
		userService.deleteUser(userId);
	}

	@PutMapping("/user/{userId}")
	public void updateUser(@RequestBody User user, @PathVariable Long userId){
		userService.updateUser(userId, user);
	}

	@PostMapping("/user")
	public void addUser(@RequestBody User user){
		userService.addUser(user);
	}
}