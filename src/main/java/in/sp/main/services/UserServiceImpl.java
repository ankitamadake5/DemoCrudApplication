package in.sp.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import in.sp.main.entity.User;
import in.sp.main.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserById(int id, User new_user) {

        return userRepository.findById(id).map(user -> {
            user.setName(new_user.getName());
            user.setAddress(new_user.getAddress());
            return userRepository.save(user);
        }).orElse(null);

    }

	@Override
	public User saveNewUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	
	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findUserByName(name);
	}
}