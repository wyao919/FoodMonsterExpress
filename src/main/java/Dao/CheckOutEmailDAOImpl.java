package Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class CheckOutEmailDAOImpl implements CheckOutEmailDAO {


    private final JavaMailSender javaMailSender;

    @Autowired
    public CheckOutEmailDAOImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;

    }

    @Override
    public void sendEmail(HttpSession session) {

        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");

        SimpleMailMessage userReplyEmail = new SimpleMailMessage();
        SimpleMailMessage adminEmail = new SimpleMailMessage();

        adminEmail.setSubject("Someone has just demo'd your App!");
        adminEmail.setTo("wyao919@gmail.com");
        adminEmail.setText("Name: " + name + "\nEmail: " + email);

        userReplyEmail.setSubject("Hi " + name + ", thank you for demoing my app!");
        userReplyEmail.setTo(email);
        userReplyEmail.setText("Thank you for taking the time to demo my app! \nFor more details, please contact me at " + "'wyao919@gmail.com'");

        javaMailSender.send(adminEmail);
        javaMailSender.send(userReplyEmail);


    }
}
