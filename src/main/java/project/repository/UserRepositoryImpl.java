package project.repository;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import project.model.User;

@Repository
public class UserRepositoryImpl extends AbstractJpaRepository<User, Integer> implements UserRepository {

	@Override
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public List<User> findAll() {
		StringBuilder jpql = new StringBuilder();

		jpql.append(" select u from User u ");

		Query query = this.getEntityManager().createQuery(jpql.toString());

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void save(User user) {
		this.create(user);
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void updateUser(User user) {
		this.update(user);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public void remove(User user) {
//		this.delete(user);
		this.delete(User.class, user.getId());
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class, isolation = Isolation.DEFAULT)
	public User findUserById(Integer id) {
		return this.getById(User.class, id);
	}

}
