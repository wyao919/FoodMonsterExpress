package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.OrderDAO;
import Entity.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void saveOrder(Orders order) {

		orderDAO.saveOrder(order);

	}

}
