package Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Distributorlogin;

public class DistributorLoginDao {
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;
	@SuppressWarnings("unchecked")
	
	public List<Distributorlogin> read() {
		List<Distributorlogin> distributor = new ArrayList<Distributorlogin>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		distributor = entityManager.createNamedQuery("Distributorlogin.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return distributor;
	}
}
