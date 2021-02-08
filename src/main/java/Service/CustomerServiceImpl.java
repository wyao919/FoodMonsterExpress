package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import Dao.CustomerDAO;
import Entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDao;

	@Override
	public Customer getCustomer(int id) {

		Customer customer = customerDao.getCustomer(id);

		return customer;
	}

	@Override
	public Customer getCurrentlyLoggedInUser(Authentication auth) {

		customerDao.getCurrentlyLoggedInUser(auth);

		return customerDao.getCurrentlyLoggedInUser(auth);
	}

	@Override
	public String getUserEMail(Authentication auth) {
		String email = customerDao.getUserEMail(auth);
		
		return email;
	}

}
