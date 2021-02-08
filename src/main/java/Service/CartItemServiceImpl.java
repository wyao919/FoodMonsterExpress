package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.CartItemDAO;
import Entity.CartItem;
import Entity.Customer;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemDAO cartItemDAO;

	@Override
	public void addOneProduct(CartItem item) {

		System.out.println(item);

		cartItemDAO.addOneProduct(item);

	}

	@Override
	public List<CartItem> findByCustomer(Customer customer) {

		List<CartItem> cartItemList = cartItemDAO.findByCustomer(customer);
		return cartItemList;
	}

	@Override
	public void deleteCartItemById(int id) {

		System.out.println("id = " + id);
		cartItemDAO.deleteCartItemById(id);
	}

	@Override
	public void updateCartItemQty(int id, int qty) {

		cartItemDAO.updateCartItemQty(id, qty);
	}

}
