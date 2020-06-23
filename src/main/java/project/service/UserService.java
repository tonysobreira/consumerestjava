package project.service;

import java.util.List;

import project.model.User;

public interface UserService {

	public List<User> getUserList();

	public List<User> findAll();

	public void save(User user);
	
	public void updateUser(User user);

	public void remove(User user);
	
	public User findUserById(Integer id);
	
	//=========
	
	public List<User> findAllJPA();

	public void saveJPA(User user);

	public void removeJPA(User user);

}
