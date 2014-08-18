package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Adminretailerregistration;

public class AdminretailerregistrationDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;

	public void create(Adminretailerregistration retailer) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(retailer);
		entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Adminretailerregistration> read() {
		List<Adminretailerregistration> allRetailer = new ArrayList<Adminretailerregistration>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		allRetailer = entityManager.createNamedQuery("Adminretailerregistration.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return allRetailer;
	}

	public void update(Adminretailerregistration retailer) {
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.find(Adminretailerregistration.class,
				retailer.getResellerId());
		entityManager.merge(retailer);
		entityManager.getTransaction().commit();
	}	
}
