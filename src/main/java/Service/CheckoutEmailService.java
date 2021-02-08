package Service;

import javax.servlet.http.HttpSession;

public interface CheckoutEmailService {
	
	void sendEmail(HttpSession session);

}
