package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Entity.CartItem;
import Entity.Customer;

@Repository
public class CartItemDAOImpl implements CartItemDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public CartItemDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void addOneProduct(CartItem item) {

		Session session = sessionFactory.getCurrentSession();
		session.save(item);

	}

	@Override
	@Transactional
	public List<CartItem> findByCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM CartItem WHERE cus_id = " + customer.getCustomerId());
		List<CartItem> resultList = query.getResultList();

		return resultList;
	}

	@Override
	@Transactional
	public void deleteCartItemById(int id) {
		Session session = sessionFactory.getCurrentSession();
		CartItem cartItem = session.get(CartItem.class, id);
		if (cartItem.getQuantity() > 1) {
			int qty = cartItem.getQuantity();
			cartItem.setQuantity(--qty);
			session.update(cartItem);
		} else {
			session.delete(cartItem);
		}

	}

	@Override
	@Transactional
	public void updateCartItemQty(int id, int qty) {
		Session session = sessionFactory.getCurrentSession();
		CartItem cartitem = session.find(CartItem.class, id);
		cartitem.setQuantity(qty);
		session.save(cartitem);

	}

}
