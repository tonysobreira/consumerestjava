package project.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractJpaRepository<T, I> {

	@PersistenceContext(unitName = "pu")
	private EntityManager entityManager;

	@Transactional(propagation = Propagation.MANDATORY)
	public T update(T object) {
		this.entityManager.merge(object);
		return object;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(T object) {
		this.entityManager.remove(object);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public void delete(Class<T> type, I id) {
		T object = this.getById(type, id);
		this.entityManager.remove(object);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public T create(T object) {
		this.entityManager.persist(object);
		return object;
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public T getById(Class<T> type, I id) {
		return (T) this.entityManager.find(type, id);
	}

	@Transactional(propagation = Propagation.MANDATORY)
	public List<T> find(String jpql) {
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
