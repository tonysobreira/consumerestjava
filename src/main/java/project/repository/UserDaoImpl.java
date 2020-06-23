package project.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import project.model.User;

@Service
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getUserList() {
		List<User> list = new ArrayList<User>();
		User user = null;
		Random random = new Random();

		for (int i = 1; i <= 10; i++) {
			user = new User();

			Integer x = random.nextInt();

			user.setId(x);
			user.setName("Name" + x);
			user.setEmail("Email" + x);

			list.add(user);
		}

		return list;
	}

}
