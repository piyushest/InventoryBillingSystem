package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Orderdetail;


public class OrderdetailDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;

	public void create(Orderdetail orderdetails) {
		
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(orderdetails);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Orderdetail> read() {
		List<Orderdetail> orderdetails = new ArrayList<Orderdetail>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		orderdetails = entityManager.createNamedQuery("Orderdetail.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return orderdetails;
	}

	public void update(Orderdetail orderdetail) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(Orderdetail.class,
				orderdetail.getOrderId());
		entityManager.merge(orderdetail);
		entityManager.getTransaction().commit();
	}
}
