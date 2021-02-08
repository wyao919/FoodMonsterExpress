package Dao;

import java.util.List;

import Entity.UserAccount;

public interface RegistrationDAO {

	void saveUser(UserAccount userAccount);
	List<UserAccount> getUserName(String name);

}