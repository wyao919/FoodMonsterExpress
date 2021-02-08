package Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Entity.UserAccount;
import Service.RegistrationService;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public RegistrationController(RegistrationService registrationService, BCryptPasswordEncoder encoder) {
        this.registrationService = registrationService;
        this.encoder = encoder;
    }

    @GetMapping("/register")
    public String showRegistrationPage(@ModelAttribute("userAccount") UserAccount userAccount) {

        return "registration-page";
    }

    @PostMapping("/save-user")
    public String saveUser(@Valid @ModelAttribute("userAccount") UserAccount userAccount, BindingResult result, RedirectAttributes ra) {

        List<UserAccount> userName = registrationService.getUserName(userAccount.getUsername());
        if (userName.size() > 0) {
            result.addError(new FieldError("userAccount", "username", "This username already exists"));
        }

        if (result.hasErrors()) {
            System.out.println("registration page has errors");
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error);
            }
            return "registration-page";
        }

        userAccount.setRoles("ROLE_USER");
        userAccount.setEnabled(1);
        userAccount.setPassword(encoder.encode(userAccount.getPassword()));
        System.out.println(userAccount);
        registrationService.saveUser(userAccount);

        ra.addFlashAttribute("message", "Success! Your registration is complete.");

        return "redirect:/login";
    }

}
