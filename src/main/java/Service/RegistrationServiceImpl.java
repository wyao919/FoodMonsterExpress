package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.RegistrationDAO;
import Entity.UserAccount;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationDAO registrationDAO;

	@Override
	public void saveUser(UserAccount userAccount) {

		registrationDAO.saveUser(userAccount);

	}

	@Override
	public List<UserAccount> getUserName(String name) {

		List<UserAccount> userName = registrationDAO.getUserName(name);

		return userName;
	}

}
