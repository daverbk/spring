package springboot.cruddemo.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import springboot.cruddemo.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

	private final EntityManager entityManager;

	public UserDaoImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}

	@Override
	public User findByUserName(String theUserName) {

		TypedQuery<User> theQuery = entityManager.createQuery("from User where userName=:uName", User.class);
		theQuery.setParameter("uName", theUserName);

		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception ignored) {
		}

		return theUser;
	}

}
