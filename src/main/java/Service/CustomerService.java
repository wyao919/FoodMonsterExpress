package Service;

import java.util.List;

import org.springframework.security.core.Authentication;

import Entity.Customer;
import Entity.UserAccount;

public interface CustomerService {
	
	Customer getCustomer(int id);
	Customer getCurrentlyLoggedInUser(Authentication auth);
	String getUserEMail(Authentication auth);





}
