package Service;

import java.util.List;

import Entity.CartItem;
import Entity.Customer;

public interface ShoppingCartService {

	public List<CartItem> listCartItems(Customer customer);

}
