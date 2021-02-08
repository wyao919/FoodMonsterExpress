package Controller;

import Entity.Menu;
import Service.CheckoutEmailService;
import Service.CustomerService;
import Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrdersController {

    private final CheckoutEmailService checkoutEmailService;
    private final MenuService menuService;
    private final CustomerService customerService;

    @Autowired
    public OrdersController(CheckoutEmailService checkoutEmailService, MenuService menuService, CustomerService customerService) {
        this.checkoutEmailService = checkoutEmailService;
        this.menuService = menuService;
        this.customerService = customerService;
    }

    @GetMapping("/placeOrderPage")
    public String showPlaceOrderPage(Model model, HttpServletRequest request, Authentication auth) {

        if (auth != null) {
            String name = customerService.getCurrentlyLoggedInUser(auth).getName();
            name = name.substring(0, 1).toUpperCase() + name.substring(1, name.length());
            String email = customerService.getUserEMail(auth);

            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);

        }

        List<Menu> menuList = menuService.getMenu();
        model.addAttribute("menuItems", menuList);

        return "order-page";

    }

    @GetMapping("/orderSent")
    public String processEmail(HttpSession session) {

        double cartTotal;
        cartTotal = Double.parseDouble(session.getAttribute("total").toString());

        if (cartTotal == 0) {
            return "redirect:/placeOrderPage";
        }

        checkoutEmailService.sendEmail(session);
        return "demo-finished-page";

    }

    @GetMapping("/searchorderpage")
    public String showSearchedItem(@RequestParam("itemName") String itemName, Model model) {

        List<Menu> menuList = menuService.searchItem(itemName);
        model.addAttribute("menuItems", menuList);

        return "order-page";
    }

}
