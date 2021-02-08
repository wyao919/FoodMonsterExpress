package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Entity.CartItem;
import Entity.Customer;
import Entity.Menu;
import Entity.UserAccount;
import Service.CartItemService;
import Service.CustomerService;
import Service.MenuService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    private final CartItemService cartItemService;
    private final CustomerService customerService;
    private final MenuService menuService;

    @Autowired
    public ShoppingCartController(CartItemService cartItemService, CustomerService customerService, MenuService menuService) {
        this.cartItemService = cartItemService;
        this.customerService = customerService;
        this.menuService = menuService;
    }

    private Customer customer;

    @GetMapping("/cart")
    public String showShoppingCart(Model model, Authentication auth, HttpServletRequest request) {

        customer = customerService.getCurrentlyLoggedInUser(auth);
        List<CartItem> cartItems = cartItemService.findByCustomer(customer);

        double runningTotal = 0;

        for (CartItem items : cartItems) {

            runningTotal += items.getQuantity() * items.getMenu().getPrice();
        }
        HttpSession session = request.getSession();
        session.setAttribute("total", runningTotal);

        model.addAttribute("runningTotal", runningTotal);
        model.addAttribute("cartItems", cartItems);

        return "shopping-cart-page";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam("menuID") int id, Model model, Authentication auth, RedirectAttributes ra) {

        if (auth == null) {
            ra.addFlashAttribute("addtocartmessage", "You must be logged in to add to cart");
            return "redirect:/login";
        }

        int qty = 1;

        Customer customer = customerService.getCurrentlyLoggedInUser(auth);
        List<CartItem> cartItems = cartItemService.findByCustomer(customer);

        Menu menuItemByID = menuService.getMenuItemByID(id);

        for (CartItem temp : cartItems) {
            if (temp.getMenu().getId() == menuItemByID.getId()) {
                qty = temp.getQuantity();
                qty++;
                cartItemService.updateCartItemQty(temp.getId(), qty);
                return "redirect:/cart";
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setMenu(menuItemByID);
        cartItem.setCustomer(customer);
        cartItem.setQuantity(qty);
        cartItemService.addOneProduct(cartItem);

        return "redirect:/cart";

    }

    @GetMapping("/deleteCartItem")
    public String deleteMenuItem(@RequestParam("cartID") int menuId, Model model, Authentication auth) {

        cartItemService.deleteCartItemById(menuId);

        return "redirect:/cart";
    }

}
