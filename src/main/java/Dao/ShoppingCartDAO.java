package Dao;

import java.util.List;

import Entity.CartItem;
import Entity.Customer;

public interface ShoppingCartDAO {

	public List<CartItem> listCartItems(Customer customer);
	
}
