package project.repository;

import java.util.List;

import project.model.User;

public interface UserRepository {

	public List<User> findAll();

	public void save(User user);
	
	public void updateUser(User user);

	public void remove(User user);
	
	public User findUserById(Integer id);

}
