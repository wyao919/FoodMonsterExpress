package Service;

import javax.servlet.http.HttpSession;

import Dao.CheckOutEmailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutEmailServiceImpl implements CheckoutEmailService{
	
	public final CheckOutEmailDAO checkOutEmailDAO;

	@Autowired
	public CheckoutEmailServiceImpl(CheckOutEmailDAO checkOutEmailDAO) {
		this.checkOutEmailDAO = checkOutEmailDAO;
	}

	@Override
	public void sendEmail(HttpSession session) {

		checkOutEmailDAO.sendEmail(session);
		
	}
}