package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.Customer;
import Entity.UserAccount;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Customer getCustomer(int id) {

		Session session = sessionFactory.getCurrentSession();

		Customer customer = session.get(Customer.class, id);

		return customer;
	}

	@Override
	@Transactional
	public Customer getCurrentlyLoggedInUser(Authentication auth) {

		if (auth == null) {
			Customer customer = null;
		}

		Session session = sessionFactory.getCurrentSession();
		List resultList = session.createQuery("FROM UserAccount WHERE username = '" + auth.getName() + "'")
				.getResultList();
		UserAccount userAccount = (UserAccount) resultList.get(0);

		Customer customer = getCustomer(userAccount.getId());

		System.out.println("printing customer" + customer);

		return customer;
	}

	@Override
	@Transactional
	public String getUserEMail(Authentication auth) {
		System.out.println("in get user email +++++++++");
		Session session = sessionFactory.getCurrentSession();
		UserAccount useraccount = (UserAccount) session.createQuery("FROM UserAccount WHERE username = '" + auth.getName() + "'").getSingleResult();

		String email = useraccount.getEmail();

		return email;
	}

}
