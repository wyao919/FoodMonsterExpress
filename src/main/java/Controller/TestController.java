package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Dao.CartItemDAO;
import Dao.CustomerDAO;
import Entity.CartItem;
import Entity.Customer;
import Entity.Menu;
import Service.CartItemService;
import Service.CustomerService;
import Service.MenuService;

@Controller
public class TestController {

	@Autowired
	MenuService menuService;

	@Autowired
	CustomerService customerDAOService;

	@Autowired
	CartItemService cartItemDAOService;

	@GetMapping("/test")
	@ResponseBody
	public String testController() {
		

		Menu menuItemByID = menuService.getMenuItemByID(3);
		Customer customer = customerDAOService.getCustomer(25);
		CartItem newItem = new CartItem();
		newItem.setCustomer(customer);
		newItem.setMenu(menuItemByID);
		newItem.setQuantity(55);

		System.out.println(newItem);
		cartItemDAOService.addOneProduct(newItem);

//		Customer customer = new Customer();
//		customer.setCustomerId(25);
//		List<CartItem> cartItemList = cartItemDAOService.findByCustomer(customer);
//		
//		System.out.println(cartItemList);
//		System.out.println();
//		System.out.println(cartItemList.size());
	
//		customerDAOService.getCurrentlyLoggedInCustomer(authentication);
		return "test";
	}

}
