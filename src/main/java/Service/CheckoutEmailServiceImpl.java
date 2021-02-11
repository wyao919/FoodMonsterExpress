package Service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CheckOutEmailDAO;

@Service
public class CheckoutEmailServiceImpl implements CheckoutEmailService{
	
	private final CheckOutEmailDAO checkOutEmailDAO;

	@Autowired
	public CheckoutEmailServiceImpl(CheckOutEmailDAO checkOutEmailDAO) {
		this.checkOutEmailDAO = checkOutEmailDAO;
	}

	@Override
	public void sendEmail(HttpSession session) {

		checkOutEmailDAO.sendEmail(session);
		
	}
}