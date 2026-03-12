package in.sp.main.services;

import java.util.List;

import in.sp.main.entity.User;

public interface UserService {
	
	List<User> getAllUser();
	
	User saveNewUser(User user);
	
	 User  getUserById(int id);
	 
	User updateUserById(int id,User user);
	
	void deleteUserById(int id);
	
	List<User> getUserByName(String name);

	
}
