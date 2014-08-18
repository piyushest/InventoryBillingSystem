package apis;

import java.util.List;

import model.Order;
import model.Orderdetail;
import Dao.OrderDao;
import Dao.OrderdetailDao;

public class CreateBillToReseller {

	OrderDao orderDao = new OrderDao();
	OrderdetailDao detail = new OrderdetailDao();
	
	public void createBillsForOrders(String reseller, String distributor,
			String name, String price) {
		int resellerId = Integer.parseInt(reseller);
		int distributorId = Integer.parseInt(distributor);
		int totalPrice = Integer.parseInt(price);
		Order singleOrder = new Order(distributorId,resellerId);
		orderDao.create(singleOrder);
		List<Order> allOrders = orderDao.read();
		Orderdetail detailedOrder = new Orderdetail(allOrders.size(),name,totalPrice);
		detail.create(detailedOrder);
		
	}
}
