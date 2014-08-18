package apis;

import java.util.ArrayList;
import java.util.List;

import Dao.OrderDao;
import Dao.OrderdetailDao;
import model.Order;
import model.Orderdetail;

/*
 * if all is true and retailerId=0 than all retailers orders will be shown
 * 
 * else if all is false and retailerId is not equal to 0 than the orders related to given 
 * retailerId will be found.*/
public class GetOrdersFromRetailers {
	OrderDao orderDao = new OrderDao();
	OrderdetailDao detailsDao = new OrderdetailDao();
	
	public List<Orderdetail> getOrders(boolean all, String retailerId,
			String distriId) {
		List<Orderdetail> orders = new ArrayList<Orderdetail>();
		int resellerId = Integer.parseInt(retailerId);
		int distributorId = Integer.parseInt(distriId);
		if (all && resellerId == 0) {
			orders=getAllOrders(distributorId);
		} else if ((!all) && resellerId != 0) {
			orders=getOrdersForReseller(resellerId, distributorId);
		}
		return orders;
	}

	public List<Orderdetail> getOrdersForReseller(int resellerId, int distributorId) {
		List<Order> allOrders= orderDao.read();
		List<Integer> orderIds = new ArrayList<Integer>();
		for(Order singleOrder: allOrders){
			if(singleOrder.getResellerId()==resellerId && singleOrder.getDistributorId()==distributorId){
				orderIds.add(singleOrder.getOrderId());
			}
		}
		List<Orderdetail> orderDetails = detailsDao.read();
		List<Orderdetail> detailsFiletered =new ArrayList<>();
		for(Orderdetail details:orderDetails){
			if(orderIds.contains(details.getOrderId())){
				detailsFiletered.add(details);
			}
		}
		return detailsFiletered;
	}

	public List<Orderdetail> getAllOrders(int distributorId) {
		List<Order> allOrders= orderDao.read();
		List<Integer> orderIds = new ArrayList<Integer>();
		for(Order singleOrder: allOrders){
			if(singleOrder.getDistributorId()==distributorId){
				orderIds.add(singleOrder.getOrderId());
			}
		}
		List<Orderdetail> orderDetails = detailsDao.read();
		List<Orderdetail> detailsFiletered =new ArrayList<>();
		for(Orderdetail details:orderDetails){
			if(orderIds.contains(details.getOrderId())){
				detailsFiletered.add(details);
			}
		}
		return detailsFiletered;

	}
}
