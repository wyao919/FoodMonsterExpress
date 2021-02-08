package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Dao.ShoppingCartDAO;
import Entity.CartItem;
import Entity.Customer;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Autowired
	ShoppingCartDAO shoppingCartDAO;

	@Override
	public List<CartItem> listCartItems(Customer customer) {

		return shoppingCartDAO.listCartItems(customer);
	}

}
