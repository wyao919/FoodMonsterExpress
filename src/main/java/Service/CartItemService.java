package Service;

import java.util.List;

import Entity.CartItem;
import Entity.Customer;

public interface CartItemService {

	void addOneProduct(CartItem item);

	List<CartItem> findByCustomer(Customer customer);
	void deleteCartItemById(int id);
	void updateCartItemQty(int id, int qty);


}
