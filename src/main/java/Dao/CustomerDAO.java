package Dao;

import org.springframework.security.core.Authentication;

import Entity.Customer;

public interface CustomerDAO {

	Customer getCustomer(int id);
	Customer getCurrentlyLoggedInUser(Authentication auth);
	String getUserEMail(Authentication auth);

}
