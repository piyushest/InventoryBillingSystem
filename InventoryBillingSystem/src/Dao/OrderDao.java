package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Order;


public class OrderDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;

	public void create(Order order) {
		
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(order);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Order> read() {
		List<Order> orders = new ArrayList<Order>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		orders = entityManager.createNamedQuery("Order.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return orders;
	}

	public void update(Order order) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(Order.class,
				order.getOrderId());
		entityManager.merge(order);
		entityManager.getTransaction().commit();
	}
}
