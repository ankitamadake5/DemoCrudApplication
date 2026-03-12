package in.sp.main.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.sp.main.entity.User;
import in.sp.main.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService)
	{
		this.userService=userService;
	}
	
	@GetMapping
	public List<User> getAllUser()
	{
		return userService.getAllUser();
	}
	
	@PostMapping
	public User createUser( @RequestBody User user)
	{
		return userService.saveNewUser(user);
	}
	
	@GetMapping("/{id}")
	public User getOneUser(@PathVariable int  id)
	{
		return userService.getUserById(id);
	}
	
	@PutMapping("/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User  user)
	{
		return userService.updateUserById(id, user);
	}
	
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int  id)
	{
		 userService.deleteUserById(id);
	}
	
	
	@GetMapping("/name/{name}")
	public List<User> getUserByName(@PathVariable String  name)
	{
		return userService.getUserByName(name);
	}
	
	
	
}
