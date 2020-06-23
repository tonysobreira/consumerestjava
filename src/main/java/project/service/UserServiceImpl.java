package project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.User;
import project.repository.UserDao;
import project.repository.UserRepository;
import project.repository.UserRepositoryJPA;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private UserRepositoryJPA userRepositoryJPA;

	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	@Override
	public void remove(User user) {
		userRepository.remove(user);
	}
	
	@Override
	public User findUserById(Integer id) {
		return userRepository.findUserById(id);
	}
	
	
	//============
	

	@Override
	public List<User> findAllJPA() {
//		return userRepositoryJPA.findAll();
		return null;
	}

	@Override
	public void saveJPA(User user) {
//		userRepositoryJPA.save(user);
	}

	@Override
	public void removeJPA(User user) {
//		userRepositoryJPA.delete(user);
	}

	
	
	

}
