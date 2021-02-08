package Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Entity.CartItem;
import Entity.Customer;

@Repository
public class ShoppingCartDAOImpl implements ShoppingCartDAO {

    private final CartItemDAO CartItemDAO;

    @Autowired
    public ShoppingCartDAOImpl(Dao.CartItemDAO cartItemDAO) {
        CartItemDAO = cartItemDAO;
    }

    @Override
    public List<CartItem> listCartItems(Customer customer) {

        return CartItemDAO.findByCustomer(customer);
    }

}
