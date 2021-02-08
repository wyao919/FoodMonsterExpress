package Dao;

import javax.servlet.http.HttpSession;

public interface CheckOutEmailDAO {

    void sendEmail(HttpSession session);

}
