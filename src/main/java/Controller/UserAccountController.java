package Controller;

import Dto.UpdatePwDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class UserAccountController {

    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final BCryptPasswordEncoder encoder;

    public UserAccountController(JdbcUserDetailsManager jdbcUserDetailsManager, BCryptPasswordEncoder encoder) {
        this.jdbcUserDetailsManager = jdbcUserDetailsManager;
        this.encoder = encoder;
    }

    @GetMapping("/updatePw")
    public String changePwPage(@ModelAttribute("userPw") UpdatePwDTO updatePwDTO, Model model)
    {
        model.addAttribute("userPw", updatePwDTO);

        return "updatePw-page";
    }

    @PostMapping("/updatePwNow")
    public String processPwUpdate(@Valid @ModelAttribute("userPw") UpdatePwDTO updatePwDTO, BindingResult result, RedirectAttributes ra, Principal principal)
    {
        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(principal.getName());

        boolean matches = encoder.matches(updatePwDTO.getOldPassword(),userDetails.getPassword());

        System.out.println(matches + " MATCHES");

        if(!matches)
        {
            result.addError(new FieldError("userPw", "oldPassword", "Old Password incorrect"));
        }
        if(!updatePwDTO.getNewPassword().equals(updatePwDTO.getrPassword()))
         {
             result.addError(new FieldError("userPw", "rPassword", "Passwords do not match"));
         }

        if (result.hasErrors()) {
            System.out.println("registration page has errors");
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println(error);
            }
            return "updatePw-page";
        }

        if(matches) {
            jdbcUserDetailsManager.changePassword(updatePwDTO.getOldPassword(), encoder.encode(updatePwDTO.getNewPassword()));
        }
       ra.addFlashAttribute("passwordChange", "You have successfully changed your password");

        return "redirect:/login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied()
    {
        return "accessDenied-page";
    }


}
