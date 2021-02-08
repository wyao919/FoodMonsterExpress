package Service;

import java.util.List;

import Entity.UserAccount;

public interface RegistrationService {

	void saveUser(UserAccount userAccount);

	List<UserAccount> getUserName(String name);

}
