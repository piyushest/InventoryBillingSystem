package Dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Adminregistration;

public class AdminregistrationDao {
	
	EntityManagerFactory factory = Persistence
			.createEntityManagerFactory("InventoryBillingSystem");
	EntityManager entityManager = null;
	@SuppressWarnings("unchecked")
	
	public List<Adminregistration> read() {
		List<Adminregistration> allAdminregistration = new ArrayList<Adminregistration>();
		entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		allAdminregistration = entityManager.createNamedQuery("Adminregistration.findAll")
				.getResultList();
		entityManager.getTransaction().commit();
		return allAdminregistration;
	}
}
