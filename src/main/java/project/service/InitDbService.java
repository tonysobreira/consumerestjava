package project.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.model.User;
import project.repository.UserRepository;

@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init() {
		System.out.println("*** INIT DATABASE START ***");
		{
			User user = new User();
			user.setName("User1");
			user.setEmail("user1@email.com");
			userRepository.save(user);
		}
		{
			User user = new User();
			user.setName("User2");
			user.setEmail("user2@email.com");
			userRepository.save(user);
		}
		{
			User user = new User();
			user.setName("User3");
			user.setEmail("user3@email.com");
			userRepository.save(user);
		}
		System.out.println("*** INIT DATABASE FINISH ***");
	}
}
